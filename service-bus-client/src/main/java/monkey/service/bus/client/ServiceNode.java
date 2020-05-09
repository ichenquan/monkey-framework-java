package monkey.service.bus.client;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import monkey.common.ObjectMapper;
import monkey.service.bus.common.ServiceRequest;
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
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class ServiceNode implements Serializable {

    private String name;
    private String host;
    private Integer port;
    private Integer weight;
    private String serviceNames;
    private RequestConfig requestConfig;
    private final int maxConnectTimeout = 5000;
    private PoolingHttpClientConnectionManager connectionManager;

    public ServiceNode() {
        // 设置连接池
        connectionManager = new PoolingHttpClientConnectionManager();
        // 设置连接池大小
        connectionManager.setMaxTotal(200);
        connectionManager.setDefaultMaxPerRoute(100);

        RequestConfig.Builder builder = RequestConfig.custom();
        // 设置连接超时
        builder.setConnectTimeout(maxConnectTimeout);
        // 设置读取超时
        builder.setSocketTimeout(maxConnectTimeout);
        // 设置从连接池获取连接实例的超时
        builder.setConnectionRequestTimeout(maxConnectTimeout);
        // 在提交请求之前 测试连接是否可用
        requestConfig = builder.build();
    }

    public boolean hasServiceProvider(ServiceRequest request) {
        return this.serviceNames.contains(request.getServiceInterfaceName());
    }

    public String execute(ServiceRequest request) {
        String path = "http://" + getHost() + ":" + getPort() + "/execute";
        Map<String, Object> params = new HashMap<>(1);
        params.put("request", ObjectMapper.toJson(request));

        CloseableHttpClient httpClient = HttpClients.createDefault();
        String response = null;
        HttpPost httpRequest = new HttpPost(path);
        CloseableHttpResponse httpResponse = null;

        try {
            httpRequest.setConfig(requestConfig);
            List<NameValuePair> nameValuePairs = new ArrayList<>(params.size());
            NameValuePair pair = new BasicNameValuePair("request", ObjectMapper.toJson(request));
            nameValuePairs.add(pair);
            httpRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs, Charset.forName("UTF-8")));
            httpResponse = httpClient.execute(httpRequest);
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
