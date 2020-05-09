package monkey.config.bus.server.service.provider;

import monkey.common.DbServiceImpl;
import monkey.common.Result;
import monkey.config.bus.data.model.ScServicePath;
import monkey.config.bus.server.service.contract.ScServicePathService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ScServicePathServiceImpl extends DbServiceImpl<ScServicePath> implements ScServicePathService {

    @Override
    public Result<List<ScServicePath>> getAll() {
        ScServicePath query = new ScServicePath();
        return super.select(query);
    }

    @Override
    public Result<ScServicePath> register(String serviceHost, String serviceNames) {
        ScServicePath query = new ScServicePath();
        query.setServiceHost(serviceHost);
        Result<List<ScServicePath>> result = super.select(query);
        if (result.isSuccess()) {
            List<ScServicePath> paths = result.getData();
            if (paths != null) {
                for (ScServicePath path : paths) {
                    super.destroy(path);
                }
            }
        }

        ScServicePath path = new ScServicePath();
        path.setModifyTime(new Date());
        path.setRemark("服务提供端注册");
        path.setServiceHost(serviceHost);
        path.setServiceNames(serviceNames);
        return super.insert(path);
    }

    @Override
    public Result delete(String serviceHost) {
        ScServicePath path = new ScServicePath();
        path.setServiceHost(serviceHost);
        return super.destroy(path);
    }

    @Override
    public Result<ScServicePath> findOne(String serviceHost) {
        ScServicePath path = new ScServicePath();
        path.setServiceHost(serviceHost);
        return super.selectOne(path);
    }
}
