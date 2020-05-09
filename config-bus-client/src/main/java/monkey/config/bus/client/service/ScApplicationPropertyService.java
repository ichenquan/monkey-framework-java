package monkey.config.bus.client.service;

import monkey.common.Result;
import monkey.config.bus.client.ConfigBusApiClient;
import monkey.config.bus.data.model.ScApplicationProperty;
import com.google.common.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ScApplicationPropertyService {

    public Result<List<ScApplicationProperty>> find(String applicationId) {
        Map<String, Object> params = new HashMap<>(1);
        params.put("applicationId", applicationId);

        Type type = new TypeToken<Result<List<ScApplicationProperty>>>() {
        }.getType();
        Result<List<ScApplicationProperty>> result = ConfigBusApiClient.call("/sc/application/property/execute", params, type);
        return result;
    }

    public Result<ScApplicationProperty> get(String applicationId, String propertyId) {
        Map<String, Object> params = new HashMap<>(1);
        params.put("applicationId", applicationId);
        params.put("propertyId", propertyId);

        Type type = new TypeToken<Result<ScApplicationProperty>>() {
        }.getType();
        Result<ScApplicationProperty> result = ConfigBusApiClient.call("/sc/application/property/get", params, type);

        return result;
    }
}
