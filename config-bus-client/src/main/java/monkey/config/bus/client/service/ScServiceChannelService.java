package monkey.config.bus.client.service;

import monkey.common.Result;
import monkey.config.bus.client.ConfigBusApiClient;
import monkey.config.bus.data.model.ScServiceChannel;
import com.google.common.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Slf4j
@Service
public class ScServiceChannelService {

    public Result<List<ScServiceChannel>> getAll() {
        Type type = new TypeToken<Result<List<ScServiceChannel>>>() {
        }.getType();
        Result<List<ScServiceChannel>> result = ConfigBusApiClient.call("/sc/service/channel/get/all", type);
        return result;
    }
}
