package monkey.service.bus.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBusConfiguration {

    @Value("${service.bus.run.mode:-}")
    private String runMode;
    @Value("${service.bus.debug.nodes:-}")
    private String debugNodes;

    public String getDebugNodes() {
        return debugNodes;
    }

    public String getRunMode() {
        return runMode;
    }
}
