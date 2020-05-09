package monkey.config.bus.server.service.contract;

import monkey.common.Result;
import monkey.config.bus.data.model.ScDbCluster;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ScDbClusterService {
    Result<ScDbCluster> insert(ScDbCluster scMysqlCluster);

    Result delete(ScDbCluster scMysqlCluster);

    Result update(ScDbCluster scMysqlCluster);

    Result<ScDbCluster> findById(Long id);

    Result<PageInfo<ScDbCluster>> findByPage(ScDbCluster scMysqlCluster, Integer pageNum, Integer pageSize);

    Result<List<ScDbCluster>> getAll();

    Result<ScDbCluster> findByClusterId(String clusterId);

    Result copyProperty(String clusterId, String newClusterId, String remark);
}