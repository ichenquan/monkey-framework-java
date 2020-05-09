package monkey.service.bus.client;

import monkey.common.ObjectMapper;
import monkey.common.Result;
import monkey.common.StatusCode;
import monkey.config.bus.client.ConfigBus;
import monkey.service.bus.common.*;

public class ServiceRequestExecutor {


    private static int EXCEED_EXECUTABLE_TIMES = 902;

    public static String execute(ServiceRequest request) {
        int i = 0;
        while (i < 3) {
            i++;
            ServiceNode node = ServiceNodeScheduler.select(request);
            ConfigBus.showSelectedPath(node.getHost(), node.getPort(), request.getServiceInterfaceName());
            if (node != null) {
                String result = node.execute(request);
                if (result != null) {
                    return result;
                } else {
                    ConfigBus.waring("服务调用失败: " + request.getServiceInterfaceName());
                }
            } else {
                ConfigBus.waring("未找到服务节点: " + request.getServiceInterfaceName());
                return ObjectMapper.toJson(new Result(StatusCode.SERVICE_NODE_NOT_FUND));
            }
        }

        return ObjectMapper.toJson(new Result(StatusCode.SERVICE_REQUEST_TIMEOUT));
    }
}
