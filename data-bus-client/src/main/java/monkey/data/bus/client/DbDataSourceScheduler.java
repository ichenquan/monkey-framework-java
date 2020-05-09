package monkey.data.bus.client;


import monkey.config.bus.data.model.ScDbNode;

import java.util.List;

public class DbDataSourceScheduler {

    private static final ThreadLocal<String> selectedNode = new ThreadLocal<>();

    public static ScDbNode select(String commandName) {
        ScDbNode selectedNode = selectMasterNode();
        if (isSelectCommand(commandName)) {
            selectedNode = selectSlaveNode();
        }
        DbDataSourceScheduler.selectedNode.set(selectedNode.getNodeId());
        return selectedNode;
    }

    private static boolean isSelectCommand(String commandName) {
        return commandName.startsWith("select");
    }

    private static ScDbNode selectMasterNode() {
        return DbCluster.getMasterNode();
    }

    private static int lastSelectedIndex = 0;

    private static ScDbNode selectSlaveNode() {
        List<ScDbNode> nodes = DbCluster.getSlaveNodes();

        int nodeCount = nodes.size();
        if (nodeCount == 0) {
            return selectMasterNode();
        }

        int selectedIndex = lastSelectedIndex;

        do {
            selectedIndex = (selectedIndex + 1) % nodeCount;
            ScDbNode selectedNode = nodes.get(selectedIndex);
            lastSelectedIndex = selectedIndex;
            return selectedNode;
        } while (selectedIndex != lastSelectedIndex);
    }

    public static String selectedNodeId() {
        return selectedNode.get();
    }
}
