package monkey.config.bus.server.service.contract;

import monkey.common.Result;
import monkey.config.bus.data.model.ScDbNode;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ScDbNodeService {

    Result<List<ScDbNode>> get(String clusterId);

    Result<ScDbNode> insert(ScDbNode scMysqlNode);

    Result delete(ScDbNode scMysqlNode);

    Result update(ScDbNode scMysqlNode);

    Result<ScDbNode> findById(Long id);

    Result<PageInfo<ScDbNode>> findByPage(ScDbNode scMysqlNode, Integer pageNum, Integer pageSize);
}
