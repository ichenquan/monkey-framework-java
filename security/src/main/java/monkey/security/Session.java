package monkey.security;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import monkey.common.RedisClient;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

import static monkey.security.Account.TOKEN_KEY;
import static monkey.security.Account.TOKEN_NAME;

public class Session {

    private static String accountParameterName;
    private static Integer localTokenExpiredMinutes;
    private static Integer remoteTokenExpiredHours;

    private static String localTokenExpiredTimePropertyName = "localExpiredTime";

    private static Map<String, JsonObject> localTokenCache = new HashMap<>();

    private static WebPermissionValidator webPermissionValidator;

    /**
     * 初始化
     *
     * @param accountParameterName     账户参数名
     * @param localTokenExpiredMinutes 本地令牌过期时间（分钟）
     * @param remoteTokenExpiredHours  远程令牌过期时间（小时）
     * @param webPermissionValidator   账户权限验证器
     */
    public static void init(String accountParameterName, Integer localTokenExpiredMinutes, Integer remoteTokenExpiredHours, WebPermissionValidator webPermissionValidator) {
        Session.accountParameterName = accountParameterName;
        Session.localTokenExpiredMinutes = localTokenExpiredMinutes;
        Session.remoteTokenExpiredHours = remoteTokenExpiredHours;
        Session.webPermissionValidator = webPermissionValidator;
    }

    /**
     * 添加账户参数
     *
     * @param request 参数请求
     */
    public static void addAccountParameter(RedisClient redisClient, WebRequest request) {
        String tokenId = request.getHeader(TOKEN_NAME);
        if (StringUtils.isBlank(tokenId)) {
            Object id = request.getSession().getAttribute(TOKEN_NAME);
            if (null != id) {
                tokenId = id.toString();
            }
        }

        if (StringUtils.isNotBlank(tokenId)) {
            JsonObject tokenData = localTokenCache.get(tokenId);
            if (null == tokenData) {
                //本地无令牌：获取远程令牌数据
                tokenData = getRemoteTokenData(redisClient, tokenId);
            } else {
                long now = System.currentTimeMillis();
                long localExpiredTime = tokenData.get(localTokenExpiredTimePropertyName).getAsLong();
                if (now > localExpiredTime) {
                    //本地有令牌，但已过期：获取远程令牌数据
                    tokenData = getRemoteTokenData(redisClient, tokenId);
                }
            }

            if (null != tokenData && tokenData.has("id")) {
                Long accountId = tokenData.get("id").getAsLong();
                request.setAttribute(TOKEN_NAME, tokenId);
                //添加账户参数
                request.addParameter(accountParameterName, accountId);
            }
        }
    }

    private static JsonObject getRemoteTokenData(RedisClient redisClient, String tokenId) {
        JsonObject tokenData = redisClient.get(TOKEN_KEY + tokenId, JsonObject.class);
        setExpiredTime(redisClient, tokenId, tokenData);
        return tokenData;
    }

    private static void setExpiredTime(RedisClient redisClient, String tokenId, JsonObject tokenData) {
        if (tokenData != null) {
            long time = System.currentTimeMillis() + localTokenExpiredMinutes * 60 * 1000L;
            tokenData.addProperty(localTokenExpiredTimePropertyName, time);
            localTokenCache.put(tokenId, tokenData);
            redisClient.set(TOKEN_KEY + tokenId, tokenData, remoteTokenExpiredHours * 60 * 60);
        }
    }

    /**
     * 创建
     *
     * @param tokenId         令牌ID
     * @param jsonAccountData 对象
     */
    public static void create(RedisClient redisClient, String tokenId, String jsonAccountData, HttpServletResponse response) {
        JsonObject tokenData = new JsonParser().parse(jsonAccountData).getAsJsonObject();
        redisClient.set(TOKEN_KEY + tokenId, tokenData, remoteTokenExpiredHours * 60 * 60);
        response.setHeader(TOKEN_NAME, tokenId);
    }

    /**
     * 删除
     */
    public static void delete(RedisClient redisClient, HttpServletRequest request, HttpServletResponse response) {
        String tokenId = request.getHeader(TOKEN_NAME);
        if (!StringUtils.isEmpty(tokenId)) {
            redisClient.delete(TOKEN_KEY + tokenId);
            localTokenCache.remove(tokenId);
        }
        response.setHeader(TOKEN_NAME, null);
    }

    static boolean validate(RedisClient redisClient, HttpServletRequest request) {
        String tokenId = request.getHeader(TOKEN_NAME);
        if (StringUtils.isEmpty(tokenId)) {
            //未登录
            return false;
        }

        //已登录：但可能伪造token
        JsonObject tokenData = localTokenCache.get(tokenId);
        if (tokenData == null) {
            tokenData = getRemoteTokenData(redisClient, tokenId);
        }
        if (tokenData == null) {
            //未找到token数据：属于伪造的token
            return false;
        }

        if (webPermissionValidator == null) {
            return true;
        } else {
            Long accountId = tokenData.get("id").getAsLong();
            return webPermissionValidator.check((WebRequest) request, accountId);
        }
    }
}
