package monkey.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class WebConnectorConfiguration {

    @Value("${server.tomcat.max-threads:200}")
    private int maxThreads;

    @Value("${server.tomcat.accept-count:100}")
    private int acceptCount;

    @Value("${server.tomcat.max-connections:10000}")
    private int maxConnections;

    @Bean
    public TomcatServletWebServerFactory createEmbeddedServletContainerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        WebConnectorCustomizer customizer = new WebConnectorCustomizer();
        customizer.setMaxThreads(maxThreads);
        customizer.setAcceptCount(acceptCount);
        customizer.setMaxConnections(maxConnections);
        factory.addConnectorCustomizers(customizer);
        return factory;
    }
}

