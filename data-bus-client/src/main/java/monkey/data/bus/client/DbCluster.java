package monkey.data.bus.client;


import monkey.config.bus.data.model.ScDbNode;

import java.util.ArrayList;
import java.util.List;

public class DbCluster {

    private static ScDbNode masterNode;
    private static List<ScDbNode> slaveNodes = new ArrayList<>();

    public static synchronized void add(List<ScDbNode> mysqlNodes) {
        slaveNodes.clear();
        for (ScDbNode node : mysqlNodes) {
            if (node.getTypeId().equals("w")) {//write：写
                masterNode = node;
            } else if (node.getTypeId().equals("r")) {//read：读
                slaveNodes.add(node);
            }
        }
    }

    public static ScDbNode getMasterNode() {
        return masterNode;
    }

    public static List<ScDbNode> getSlaveNodes() {
        return slaveNodes;
    }
}
