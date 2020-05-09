package monkey.service.bus.client;

import monkey.common.ObjectContainer;
import monkey.common.ApplicationMode;
import monkey.config.bus.client.ConfigBus;
import monkey.config.bus.client.service.ScServicePathService;
import monkey.config.bus.data.model.ScServiceChannel;
import monkey.config.bus.data.model.ScServicePath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceNodeManager {

    private static Map<String, ServiceNode> serviceNodes = new ConcurrentHashMap<>();
    private final static Logger log = LoggerFactory.getLogger(ServiceNodeManager.class);

    public static List<ServiceNode> getServiceNodes() {
        Object[] values = serviceNodes.values().toArray();
        List<ServiceNode> nodes = new ArrayList<>();
        for (Object v : values) {
            nodes.add((ServiceNode) v);
        }
        return nodes;
    }

    public static void loadServiceNodes() {
        ServiceChannel.loadAll();
        List<ScServicePath> paths = ObjectContainer.getObject(ScServicePathService.class).getAll().getData();
        for (ScServicePath path : paths) {
            ServiceNodeManager.addServiceNode(path.getServiceHost(), path.getServiceNames());
        }
    }

    public static synchronized void addServiceNode(String serviceProvider, String serviceNames) {
        String provider = serviceProvider;
        if (ApplicationMode.isK8s()) {
            provider = findK8sServiceProvider(serviceProvider);
            if (provider == null) {
                ConfigBus.exit("未找到服务提供端: " + serviceProvider);
                return;
            }
        }

        if (!serviceNodes.containsKey(provider)) {
            ServiceNode node = createServiceNode(provider, serviceNames);
            serviceNodes.put(provider, node);
        }

        log.info("添加服务节点: " + serviceProvider + serviceNames);
    }

    public static synchronized void removeServiceNode(String serviceProvider) {
        if (serviceNodes.containsKey(serviceProvider)) {
            serviceNodes.remove(serviceProvider);
            log.info("移除服务节点: " + serviceProvider);
        }
    }

    private static String findK8sServiceProvider(String serviceProvider) {
        ScServiceChannel channel = ServiceChannel.find(serviceProvider);
        if (channel == null) {
            ServiceChannel.loadAll();
            channel = ServiceChannel.find(serviceProvider);
        }

        if (channel != null) {
            String host = channel.getServiceHost();
            String port = channel.getServicePort();
            String providerName = host + ":" + port;
            return providerName;
        }

        return null;
    }

    private static ServiceNode createServiceNode(String serviceProvider, String serviceNames) {
        String[] values = serviceProvider.split(":");
        String host = values[0];
        int port = Integer.parseInt(values[1]);
        ServiceNode node = new ServiceNode();
        node.setHost(host);
        node.setPort(port);
        node.setWeight(100);
        node.setServiceNames(serviceNames);
        return node;
    }

}
