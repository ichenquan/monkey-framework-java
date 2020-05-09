package monkey.service.bus.client;

import monkey.common.ObjectContainer;
import monkey.common.ApplicationMode;
import monkey.config.bus.client.service.ScServiceChannelService;
import monkey.config.bus.data.model.ScServiceChannel;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceChannel {

    private static Map<String, ScServiceChannel> serviceChannels = new ConcurrentHashMap<>();

    public static void loadAll() {
        if (ApplicationMode.isK8s()) {
            List<ScServiceChannel> channels = ObjectContainer.getObject(ScServiceChannelService.class).getAll().getData();
            for (ScServiceChannel channel : channels) {
                serviceChannels.put(channel.getApplicationId(), channel);
            }
        }
    }

    public static ScServiceChannel find(String serviceProvider) {
        return serviceChannels.get(serviceProvider);
    }
}
