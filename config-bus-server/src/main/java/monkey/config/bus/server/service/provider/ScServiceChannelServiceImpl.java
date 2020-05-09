package monkey.config.bus.server.service.provider;

import monkey.common.DbServiceImpl;
import monkey.common.Result;
import monkey.config.bus.data.model.ScServiceChannel;
import monkey.config.bus.server.service.contract.ScServiceChannelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScServiceChannelServiceImpl extends DbServiceImpl<ScServiceChannel> implements ScServiceChannelService {

    @Override
    public Result<List<ScServiceChannel>> getAll() {
        ScServiceChannel query = new ScServiceChannel();
        return super.select(query);
    }
}
