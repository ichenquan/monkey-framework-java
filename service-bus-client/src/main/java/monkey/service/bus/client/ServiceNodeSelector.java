package monkey.service.bus.client;


import monkey.service.bus.common.ServiceRequest;

import java.util.List;

public class ServiceNodeSelector {

    private int lastSelectedIndex = 0;

    public ServiceNode select(ServiceRequest request) {
        List<ServiceNode> serviceNodes = ServiceNodeManager.getServiceNodes();
        int nodeCount = serviceNodes.size();
        if (nodeCount == 0) {
            return null;
        }

        int selectedIndex = this.lastSelectedIndex;

        do {
            selectedIndex = (selectedIndex + 1) % nodeCount;
            ServiceNode node = serviceNodes.get(selectedIndex);
            if (node.hasServiceProvider(request)) {
                if (node.getWeight() > 0) {
                    this.lastSelectedIndex = selectedIndex;
                    return node;
                }
            }
        } while (selectedIndex != this.lastSelectedIndex);

        return null;
    }
}