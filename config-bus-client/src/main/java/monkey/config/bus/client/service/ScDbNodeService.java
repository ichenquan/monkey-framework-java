package monkey.config.bus.client.service;

import monkey.common.Result;
import monkey.config.bus.client.ConfigBusApiClient;
import monkey.config.bus.data.model.ScDbNode;
import com.google.common.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ScDbNodeService {

    public Result<List<ScDbNode>> get(String clusterId) {
        Map<String, Object> params = new HashMap<>(1);
        params.put("clusterId", clusterId);

        Type type = new TypeToken<Result<List<ScDbNode>>>() {
        }.getType();
        Result<List<ScDbNode>> result = ConfigBusApiClient.call("/sc/db/node/get", params, type);
        return result;
    }
}
