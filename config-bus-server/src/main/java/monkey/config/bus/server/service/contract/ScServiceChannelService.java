package monkey.config.bus.server.service.contract;

import monkey.common.Result;
import monkey.config.bus.data.model.ScServiceChannel;

import java.util.List;

public interface ScServiceChannelService {

    Result<List<ScServiceChannel>> getAll();
}
