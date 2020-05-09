package monkey.service.bus.client;

import monkey.common.ObjectContainer;

//服务模式
public class ServiceMode {

    private static String mode = null;

    public static boolean isDebug() {
        if (mode == null) {
            ServiceBusConfiguration configuration = ObjectContainer.getObject(ServiceBusConfiguration.class);
            mode = configuration.getRunMode();
        }

        return mode.equals("debug");
    }
}
