package monkey.config.bus.server.service.contract;

import monkey.common.Result;
import monkey.config.bus.data.model.ScDbPath;
import com.github.pagehelper.PageInfo;

public interface ScDbPathService {

    Result<ScDbPath> get(String applicationId);

    Result<ScDbPath> insert(ScDbPath scMysqlPath);

    Result delete(ScDbPath scMysqlPath);

    Result update(ScDbPath scMysqlPath);

    Result<ScDbPath> findById(Long id);

    Result<PageInfo<ScDbPath>> findByPage(ScDbPath scMysqlPath, Integer pageNum, Integer pageSize);
}
