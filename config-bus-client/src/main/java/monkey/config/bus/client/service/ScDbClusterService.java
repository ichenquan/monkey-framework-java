package monkey.config.bus.client.service;

import monkey.common.Result;
import monkey.config.bus.client.ConfigBusApiClient;
import monkey.config.bus.data.model.ScDbCluster;
import com.google.common.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Slf4j
@Service
public class ScDbClusterService {

    public Result<List<ScDbCluster>> getAll() {
        Type type = new TypeToken<Result<List<ScDbCluster>>>() {
        }.getType();
        Result<List<ScDbCluster>> result = ConfigBusApiClient.call("/sc/db/cluster/get/all", type);
        return result;
    }
}