package monkey.config.bus.server.service.provider;

import monkey.common.DbServiceImpl;
import monkey.common.Result;
import monkey.common.StringHelper;
import monkey.config.bus.data.model.ScDbCluster;
import monkey.config.bus.server.service.contract.ScDbClusterService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.List;


@Service
public class ScDbClusterServiceImpl extends DbServiceImpl<ScDbCluster> implements ScDbClusterService {
    private String serviceCode = "sc_dbCluster";

    @Override
    public Result<ScDbCluster> insert(ScDbCluster scMysqlCluster) {
        String methodCode = "insert";
        if (scMysqlCluster == null)
            return new Result<>(serviceCode, methodCode, 501);
        if (StringUtils.isBlank(scMysqlCluster.getClusterId()))
            return new Result<>(serviceCode, methodCode, 502);
        return super.insert(scMysqlCluster);
    }

    @Override
    public Result delete(ScDbCluster scMysqlCluster) {
        String methodCode = "delete";
        if (scMysqlCluster == null)
            return new Result<>(serviceCode, methodCode, 501);
        return super.delete(scMysqlCluster);
    }

    @Override
    public Result update(ScDbCluster scMysqlCluster) {
        String methodCode = "update";
        if (scMysqlCluster == null)
            return new Result<>(serviceCode, methodCode, 501);
        return super.update(scMysqlCluster);
    }

    @Override
    public Result<ScDbCluster> findById(Long id) {
        String methodCode = "findById";
        if (id == null)
            return new Result<>(serviceCode, methodCode, 501);
        return super.selectByPrimaryKey(id);
    }

    @Override
    public Result<ScDbCluster> findByClusterId(String clusterId) {
        String methodCode = "findByClusterId";
        if (clusterId == null)
            return new Result<>(serviceCode, methodCode, 501);
        ScDbCluster query = new ScDbCluster();
        query.setClusterId(clusterId);
        return super.selectOne(query);
    }

    @Override
    public Result copyProperty(String clusterId, String newClusterId, String remark) {
        return null;
    }

    @Override
    public Result<PageInfo<ScDbCluster>> findByPage(ScDbCluster scMysqlCluster, Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageNum <= 0)
            pageNum = 1;
        if (pageSize == null || pageSize <= 0)
            pageSize = 10;
        Weekend<ScDbCluster> weekend = Weekend.of(ScDbCluster.class);
        WeekendCriteria<ScDbCluster, Object> criteria = weekend.weekendCriteria();
        if (StringHelper.isNotEmpty(scMysqlCluster.getClusterId())) {
            String clusterId = "%" + scMysqlCluster.getClusterId() + "%";
            criteria.andLike(ScDbCluster::getClusterId, clusterId);
            //criteria.andEqualTo(ScMysqlCluster::getClusterId, scMysqlCluster.getClusterId());
        }
        weekend.orderBy("createTime").desc();
        return super.selectForPage(weekend, pageNum, pageSize);
    }

    @Override
    public Result<List<ScDbCluster>> getAll() {
        return super.selectAll();
    }
}