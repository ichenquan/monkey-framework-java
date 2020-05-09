package monkey.common;

/**
 * Package: monkey.common
 * FileName: StatusCode
 * Description: 状态代码
 * Author: ChenQ
 * Date:  2020/4/28
 */
public class StatusCode {

    //成功
    public static int SUCCESS = 800;
    //服务暂停：用于服务熔断处理
    public static int SERVICE_PAUSED = 900;
    //服务请求超时
    public static int SERVICE_REQUEST_TIMEOUT = 901;
    //服务消费端出错
    public static int SERVICE_CONSUMER_ERROR = 902;
    //服务提供端出错
    public static int SERVICE_PROVIDER_ERROR = 903;
    //服务节点未找到
    public static int SERVICE_NODE_NOT_FUND = 904;
}
