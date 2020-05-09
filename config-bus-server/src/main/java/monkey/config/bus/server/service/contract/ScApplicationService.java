package monkey.config.bus.server.service.contract;

import monkey.common.Result;
import monkey.config.bus.data.model.ScApplication;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ScApplicationService {

    Result<ScApplication> save(ScApplication scApplication);

    Result update(ScApplication scApplication);

    Result<PageInfo<ScApplication>> findByPage(ScApplication scApplication, Integer pageNum, Integer pageSize);

    Result<ScApplication> copyProperty(String applicationId, String newApplicationId, String remark);

    Result<List<ScApplication>> getAll();
}


