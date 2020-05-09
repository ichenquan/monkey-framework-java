package monkey.service.bus.server;

import monkey.common.IPHelper;
import monkey.common.ObjectContainer;
import monkey.common.ApplicationMode;
import monkey.config.bus.client.ConfigBus;
import monkey.config.bus.client.service.ScServicePathService;
import monkey.config.bus.data.model.ScServiceParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class ServiceNode {

    private final static Logger logger = LoggerFactory.getLogger(ServiceNode.class);

    public static void register(int servicePort, String serviceContract) {
        Set<Class> classes = ServiceClassFinder.scan(serviceContract, null);
        String serviceNames = "|";
        for (Class<?> c : classes) {
            if (c.isInterface()) {
                String serviceName = c.getName();
                serviceNames = serviceNames + serviceName + "|";
            }
        }

        if (serviceNames.equals("|")) {
            ConfigBus.exit("未找到服务接口:" + serviceContract);
        } else {
            logger.info("注册服务: " + serviceNames);
        }

        if (ApplicationMode.isK8s()) {
            registerAsK8s(serviceNames);
        } else {
            registerAsFast(serviceNames, servicePort);
        }
    }

    private static void registerAsK8s(String serviceNames) {
        String serviceHost = ConfigBus.getApplicationId();
        ObjectContainer.getObject(ScServicePathService.class).register(serviceHost, serviceNames);
        notifyConsumers(serviceHost, serviceNames);
    }

    private static void registerAsFast(String serviceNames, int servicePort) {
        String serverIp = IPHelper.getLocalAddress();
        String serviceHost = String.format("%s:%d", serverIp, servicePort);
        ObjectContainer.getObject(ScServicePathService.class).register(serviceHost, serviceNames);
        notifyConsumers(serviceHost, serviceNames);
    }

    private static void notifyConsumers(String serviceHost, String serviceNames) {
        ScServiceParameter parameter = new ScServiceParameter();
        parameter.setChangedType("add-node");
        parameter.setServiceHost(serviceHost);
        parameter.setServiceNames(serviceNames);
    }
}
