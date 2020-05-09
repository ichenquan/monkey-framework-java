package monkey.config.bus.server.service.provider;

import monkey.common.DbServiceImpl;
import monkey.common.Result;
import monkey.common.StringHelper;
import monkey.config.bus.data.model.ScDbPath;
import monkey.config.bus.server.service.contract.ScDbPathService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

@Service
public class ScDbPathServiceImpl extends DbServiceImpl<ScDbPath> implements ScDbPathService {
    private String serviceCode = "sc_dbPath";

    @Override
    public Result<ScDbPath> get(String applicationId) {
        ScDbPath query = new ScDbPath();
        query.setApplicationId(applicationId);
        return super.selectOne(query);
    }

    @Override
    public Result<ScDbPath> insert(ScDbPath scMysqlPath) {
        String methodCode = "insert";
        if (scMysqlPath == null)
            return new Result<>(serviceCode, methodCode, 501);
        if (StringUtils.isBlank(scMysqlPath.getApplicationId()))
            return new Result<>(serviceCode, methodCode, 502);
        if (StringUtils.isBlank(scMysqlPath.getClusterId()))
            return new Result<>(serviceCode, methodCode, 503);
        return super.insert(scMysqlPath);
    }

    @Override
    public Result<?> delete(ScDbPath scMysqlPath) {
        String methodCode = "delete";
        if (scMysqlPath == null)
            return new Result<>(serviceCode, methodCode, 501);
        return super.delete(scMysqlPath);
    }

    @Override
    public Result<?> update(ScDbPath scMysqlPath) {
        String methodCode = "update";
        if (scMysqlPath == null)
            return new Result<>(serviceCode, methodCode, 501);
        return super.update(scMysqlPath);
    }

    @Override
    public Result<ScDbPath> findById(Long id) {
        String methodCode = "findById";
        if (id == null)
            return new Result<>(serviceCode, methodCode, 501);
        return super.selectByPrimaryKey(id);
    }

    @Override
    public Result<PageInfo<ScDbPath>> findByPage(ScDbPath scMysqlPath, Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageNum <= 0)
            pageNum = 1;
        if (pageSize == null || pageSize <= 0)
            pageSize = 10;
        Weekend<ScDbPath> weekend = Weekend.of(ScDbPath.class);
        WeekendCriteria<ScDbPath, Object> criteria = weekend.weekendCriteria();
        if (StringHelper.isNotEmpty(scMysqlPath.getClusterId())) {
            String clusterId = "%" + scMysqlPath.getClusterId() + "%";
            criteria.andLike(ScDbPath::getClusterId, clusterId);
            //criteria.andEqualTo(ScMysqlPath::getClusterId, scMysqlPath.getClusterId());
        }
        if (StringHelper.isNotEmpty(scMysqlPath.getApplicationId())) {
            String applicationId = "%" + scMysqlPath.getApplicationId() + "%";
            criteria.andLike(ScDbPath::getApplicationId, applicationId);
           // criteria.andEqualTo(ScMysqlPath::getApplicationId, scMysqlPath.getApplicationId());
        }
        weekend.orderBy("createTime").desc();
        return super.selectForPage(weekend, pageNum, pageSize);
    }
}
