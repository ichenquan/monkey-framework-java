package monkey.config.bus.data.model;

import java.util.List;

public class ScDbParameter {

    public static String type = "mysql.parameter";

    private String applicationId;

    private List<ScDbNode> nodes;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public List<ScDbNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<ScDbNode> nodes) {
        this.nodes = nodes;
    }
}
