package monkey.config.bus.client.service;

import monkey.common.Result;
import monkey.config.bus.client.ConfigBusApiClient;
import monkey.config.bus.data.model.ScApplication;
import com.google.common.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Slf4j
@Service
public class ScApplicationService {

    public Result<List<ScApplication>> getAll() {
        Type type = new TypeToken<Result<List<ScApplication>>>(){}.getType();
        Result<List<ScApplication>> result = ConfigBusApiClient.call("/sc/application/get/all", type);
        return result;
    }
}
