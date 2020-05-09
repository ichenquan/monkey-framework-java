package monkey.config.bus.client.service;

import monkey.common.Result;
import monkey.config.bus.client.ConfigBusApiClient;
import monkey.config.bus.data.model.ScServicePath;
import com.google.common.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ScServicePathService {

    public Result<List<ScServicePath>> getAll() {
        Type type = new TypeToken<Result<List<ScServicePath>>>(){}.getType();
        Result<List<ScServicePath>> result = ConfigBusApiClient.call("/sc/service/path/get/all", type);
        return result;
    }

    public Result<ScServicePath> register(String serviceHost, String serviceNames) {
        Map<String, Object> params = new HashMap<>(3);
        params.put("serviceHost", serviceHost);
        params.put("serviceNames", serviceNames);

        Type type = new TypeToken<Result<ScServicePath>>() {
        }.getType();
        Result<ScServicePath> result = ConfigBusApiClient.call("/sc/service/path/register", params, type);
        return result;
    }
}
