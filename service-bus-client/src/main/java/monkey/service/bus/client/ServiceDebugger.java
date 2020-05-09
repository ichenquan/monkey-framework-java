package monkey.service.bus.client;

import monkey.common.IPHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceDebugger {

    private static Map<String, String> debugNodes = new ConcurrentHashMap<>();
    private final static Logger log = LoggerFactory.getLogger(ServiceDebugger.class);

    public static void addServiceNodes(String debugNodes) {
        String[] nodes = debugNodes.split(",");
        for (String node : nodes) {
            String[] values = node.split("@");
            String key = values[0];
            String value = values[1];
            ServiceDebugger.debugNodes.put(key, value);
            log.info("添加调试节点: " + node);
        }
    }

    public static ServiceNode selectServiceNode(String serviceName) {
        for (String key : debugNodes.keySet()) {
            if (serviceName.startsWith(key)) {
                String debugNodeName = debugNodes.get(key);
                if (debugNodeName.startsWith("localhost:")) {
                    debugNodeName = IPHelper.getLocalAddress() + ":" + debugNodeName.split(":")[1];
                }
                List<ServiceNode> nodes = ServiceNodeManager.getServiceNodes();
                for (ServiceNode node : nodes) {
                    String nodeName = node.getHost() + ":" + node.getPort();
                    if (nodeName.equals(debugNodeName)) {
                        log.info("选中调试节点: " + nodeName);
                        return node;
                    }
                }
            }
        }
        return null;
    }
}
