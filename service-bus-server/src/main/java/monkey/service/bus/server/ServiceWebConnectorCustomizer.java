package monkey.service.bus.server;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.stereotype.Component;

@Component
public class ServiceWebConnectorCustomizer implements TomcatConnectorCustomizer {

    @Override
    public void customize(Connector connector) {
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
        protocol.setMaxConnections(20000);
        protocol.setMaxThreads(500);
    }
}
