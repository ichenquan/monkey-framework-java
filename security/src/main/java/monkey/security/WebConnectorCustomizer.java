package monkey.security;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;


public class WebConnectorCustomizer implements TomcatConnectorCustomizer {

    private int maxThreads;

    private int maxConnections;

    private int acceptCount;

    @Override
    public void customize(Connector connector) {
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
        protocol.setMaxThreads(maxThreads);
        protocol.setAcceptCount(acceptCount);
        protocol.setMaxConnections(maxConnections);
    }

    public void setMaxThreads(int maxThreads) {
        this.maxThreads = maxThreads;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public void setAcceptCount(int acceptCount) {
        this.acceptCount = acceptCount;
    }
}

