package monkey.service.bus.client;

import monkey.common.ObjectContainer;
import monkey.common.ApplicationMode;
import monkey.config.bus.client.ConfigBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceBus {

    private static boolean isFirstStart = true;
    private static Map<String, Object> serviceProviders = new ConcurrentHashMap<>();
    private final static Logger logger = LoggerFactory.getLogger(ServiceBus.class);

    public static <T> T create(Class<T> clazz) {
        return create(clazz, 30000);
    }

    public static <T> T create(Class<T> clazz, int timeout) {
        String typeName = clazz.getTypeName();
        if (serviceProviders.containsKey(typeName)) {
            T instance = (T) serviceProviders.get(typeName);
            return instance;
        } else {
            ServiceClient<T> client = new ServiceClient<T>(clazz);
            client.setTimeout(timeout);
            T instance = client.newInstance();
            serviceProviders.put(typeName, instance);
            return instance;
        }
    }

    public static synchronized void start() {
        if (isFirstStart) {
            isFirstStart = false;

            ConfigBus.start();

            if (ApplicationMode.isFast()) {
                //只有FAST模式才能调试程序
                if (ServiceMode.isDebug()) {
                    logger.info("服务调试模式: 已开启");
                    String propertyId = "service.bus.debug.nodes";
                    String debugNodes = ObjectContainer.getObject(ServiceBusConfiguration.class).getDebugNodes();
                    if (debugNodes.equals("-")) {
                        ConfigBus.waringWhenPropertyNotFound(propertyId);
                    }
                    ServiceTimer.setTimeout(180);
                    ServiceDebugger.addServiceNodes(debugNodes);
                } else {
                    logger.info("服务调试模式: 已关闭");
                }
            }

            ServiceNodeManager.loadServiceNodes();
        }
    }
}