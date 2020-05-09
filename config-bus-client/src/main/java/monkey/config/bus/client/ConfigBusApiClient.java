package monkey.config.bus.client;

import lombok.extern.slf4j.Slf4j;
import monkey.common.ObjectMapper;
import monkey.common.StringHelper;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ConfigBusApiClient {

    private static String apiServer = null;

    public static String getApiServer() {
        /**
         *        k8s处理方式
         *        1、通过ConfigMap设置配置总线地址；
         *        2、把配置总线地址注入到Pod容器环境变量中，
         *        3、Pod容器程序通过环境变量取得配置总线地址
         */
        if (StringHelper.isEmpty(apiServer)) {
            apiServer = System.getenv().get(ConfigBus.SERVER_URL_ENV_VAR_NAME);
            if (apiServer == null) {
                ConfigBus.exit("配置总线地址未找到");
            }
        }

        return apiServer;
    }

    public static <T> T call(String path, Type resultType) {
        return call(path, new HashMap<>(0), resultType);
    }

    public static <T> T call(String path, Map<String, Object> params, Type resultType) {
        String server = getApiServer();
        String data = call(server + path, params);
        return ObjectMapper.fromJson(data, resultType);
    }

    private static PoolingHttpClientConnectionManager connectionManager;
    private static RequestConfig requestConfig;
    private static final int MaxConnectTimeout = 5000;

    static {
        // 设置连接池
        connectionManager = new PoolingHttpClientConnectionManager();
        // 设置连接池大小
        connectionManager.setMaxTotal(200);
        connectionManager.setDefaultMaxPerRoute(100);

        RequestConfig.Builder builder = RequestConfig.custom();
        // 设置连接超时
        builder.setConnectTimeout(MaxConnectTimeout);
        // 设置读取超时
        builder.setSocketTimeout(MaxConnectTimeout);
        // 设置从连接池获取连接实例的超时
        builder.setConnectionRequestTimeout(MaxConnectTimeout);
        // 在提交请求之前 测试连接是否可用
        requestConfig = builder.build();
    }

    private static String call(String path, Map<String, Object> params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String response = null;
        HttpPost httpPostRequest = new HttpPost(path);
        CloseableHttpResponse httpResponse = null;

        try {
            httpPostRequest.setConfig(requestConfig);
            List<NameValuePair> pairList = new ArrayList<>(params.size());
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry
                        .getValue().toString());
                pairList.add(pair);
            }
            httpPostRequest.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("UTF-8")));
            httpResponse = httpClient.execute(httpPostRequest);
            HttpEntity entity = httpResponse.getEntity();
            response = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            if (httpResponse != null) {
                try {
                    EntityUtils.consume(httpResponse.getEntity());
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }

        return response;
    }
}
