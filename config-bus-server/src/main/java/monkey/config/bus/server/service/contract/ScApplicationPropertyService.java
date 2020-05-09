package monkey.config.bus.server.service.contract;

import monkey.common.Result;
import monkey.config.bus.data.model.ScApplicationProperty;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ScApplicationPropertyService {

    Result<ScApplicationProperty> get(String applicationId, String propertyId);

    Result<List<ScApplicationProperty>> find(String applicationId);

    Result<ScApplicationProperty> save(ScApplicationProperty scApplicationProperty);

    Result update(ScApplicationProperty scApplicationProperty);

    Result<PageInfo<ScApplicationProperty>> findByPage(ScApplicationProperty scApplicationProperty, Integer pageNum, Integer pageSize);
}

