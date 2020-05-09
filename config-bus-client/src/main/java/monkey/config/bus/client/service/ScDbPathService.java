package monkey.config.bus.client.service;

import monkey.common.Result;
import monkey.config.bus.client.ConfigBusApiClient;
import monkey.config.bus.data.model.ScDbPath;
import com.google.common.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class ScDbPathService {

    public Result<ScDbPath> get(String applicationId) {
        Map<String, Object> params = new HashMap<>(1);
        params.put("applicationId", applicationId);

        Type type = new TypeToken<Result<ScDbPath>>() {
        }.getType();
        Result<ScDbPath> result = ConfigBusApiClient.call("/sc/db/path/get", params, type);
        return result;
    }
}
