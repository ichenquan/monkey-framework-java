package monkey.config.bus.data.model;

public class ScServiceParameter {

    //变更类型：add-node,remove-node
    private String changedType;
    private String serviceHost;
    private String serviceNames;

    public static String type = "service.parameter";

    public String getServiceHost() {
        return serviceHost;
    }

    public void setServiceHost(String serviceHost) {
        this.serviceHost = serviceHost;
    }

    public String getServiceNames() {
        return serviceNames;
    }

    public void setServiceNames(String serviceNames) {
        this.serviceNames = serviceNames;
    }

    public String getChangedType() {
        return changedType;
    }

    public void setChangedType(String changedType) {
        this.changedType = changedType;
    }
}

