package monkey.config.bus.server.service.contract;

import monkey.common.Result;
import monkey.config.bus.data.model.ScServicePath;

import java.util.List;

public interface ScServicePathService {

    Result<List<ScServicePath>> getAll();

    Result<ScServicePath> register(String serviceHost, String serviceNames);

    Result delete(String serviceHost);

    Result<ScServicePath> findOne(String serviceHost);
}
