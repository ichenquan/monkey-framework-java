package monkey.config.bus.client;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class ConfigBusConfiguration {

    @Value("${application.id}")
    private String applicationId;
    @Value("${web.bus.debug.mode.open:-}")
    private String debugModeOpen;
}
