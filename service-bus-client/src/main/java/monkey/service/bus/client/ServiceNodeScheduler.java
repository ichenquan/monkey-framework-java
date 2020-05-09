package monkey.service.bus.client;

import monkey.common.ApplicationMode;
import monkey.service.bus.common.ServiceRequest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceNodeScheduler {

    private static Map<String, ServiceNodeSelector> selectors = new ConcurrentHashMap<>();

    public static ServiceNode select(ServiceRequest request) {
        String serviceName = request.getServiceInterfaceName();

        if (ServiceMode.isDebug()) {
            if (ApplicationMode.isFast()) {
                ServiceNode node = ServiceDebugger.selectServiceNode(serviceName);
                if (node != null) {
                    return node;
                }
            }
        }

        if (selectors.containsKey(serviceName)) {
            return selectors.get(serviceName).select(request);
        } else {
            ServiceNodeSelector selector = new ServiceNodeSelector();
            selectors.put(serviceName, selector);
            return selector.select(request);
        }
    }
}
