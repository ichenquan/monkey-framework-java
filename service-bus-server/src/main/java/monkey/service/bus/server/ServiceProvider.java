package monkey.service.bus.server;

import monkey.config.bus.client.ConfigBus;
import monkey.data.bus.client.DataBus;

public class ServiceProvider {

    private static boolean isFirstStart = true;
    private static Integer port = 8080;
    private static String serviceContract;

    public static synchronized void start() {
        if (isFirstStart) {
            isFirstStart = false;

            ConfigBus.start();
            DataBus.start();

            if (serviceContract == null) {
                ConfigBus.exitWhenPropertyNotFound("service.contract");
            }

            ServiceNode.register(port, serviceContract);
        }
    }

    public static void setPort(Integer port) {
        ServiceProvider.port = port;
    }

    public static void setServiceContract(String serviceContract) {
        ServiceProvider.serviceContract = serviceContract;
    }
}
