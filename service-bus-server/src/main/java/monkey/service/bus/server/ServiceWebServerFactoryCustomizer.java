package monkey.service.bus.server;


import com.google.common.reflect.TypeToken;
import monkey.common.Result;
import monkey.config.bus.client.ConfigBus;
import monkey.config.bus.client.ConfigBusApiClient;
import monkey.config.bus.data.model.ScApplicationProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

@Component
public class ServiceWebServerFactoryCustomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Value("${application.id}")
    private String applicationId;

    @Value("${service.contract}")
    private String serviceContract;

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        ConfigBus.setApplicationId(applicationId);
        Integer port = getPort();
        ServiceProvider.setPort(port);
        factory.setPort(port);
        ServiceProvider.setServiceContract(serviceContract);
        factory.addConnectorCustomizers(new ServiceWebConnectorCustomizer());
    }

    private Integer getPort() {
        String propertyId = "service.bus.port";
        Map<String, Object> params = new HashMap<>(1);
        params.put("applicationId", applicationId);
        params.put("propertyId", propertyId);

        Type type = new TypeToken<Result<ScApplicationProperty>>() {
        }.getType();
        Result<ScApplicationProperty> result = ConfigBusApiClient.call("/sc/application/property/get", params, type);
        Integer port = Integer.valueOf(result.getData().getPropertyValue());
        if (port == null) {
            ConfigBus.exitWhenPropertyNotFound(propertyId);
        }
        return port;
    }
}
