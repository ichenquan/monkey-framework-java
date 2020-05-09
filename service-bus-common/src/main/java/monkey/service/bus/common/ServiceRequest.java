package monkey.service.bus.common;

import java.util.List;

public class ServiceRequest {

    private String serviceInterfaceName;
    private String serviceMethodName;
    private List<ServiceParameter> serviceParameters;

    public String getServiceMethodName() {
        return serviceMethodName;
    }

    public void setServiceMethodName(String serviceMethodName) {
        this.serviceMethodName = serviceMethodName;
    }

    public String getServiceInterfaceName() {
        return serviceInterfaceName;
    }

    public void setServiceInterfaceName(String serviceInterfaceName) {
        this.serviceInterfaceName = serviceInterfaceName;
    }

    public void setServiceParameters(List<ServiceParameter> serviceParameters) {
        this.serviceParameters = serviceParameters;
    }

    public List<ServiceParameter> getServiceParameters() {
        return this.serviceParameters;
    }
}
