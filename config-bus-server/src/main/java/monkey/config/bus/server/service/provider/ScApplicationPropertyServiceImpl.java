package monkey.config.bus.server.service.provider;

import monkey.common.DbServiceImpl;
import monkey.common.Result;
import monkey.common.StringHelper;
import monkey.config.bus.data.model.ScApplicationProperty;
import monkey.config.bus.server.service.contract.ScApplicationPropertyService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.List;

@Service
public class ScApplicationPropertyServiceImpl extends DbServiceImpl<ScApplicationProperty> implements ScApplicationPropertyService {

    private String serviceCode = "sc_applicationProperty";

    @Override
    public Result<ScApplicationProperty> get(String applicationId, String propertyId) {
        ScApplicationProperty query = new ScApplicationProperty();
        query.setApplicationId(applicationId);
        query.setPropertyId(propertyId);
        return super.selectOne(query);
    }

    @Override
    public Result<List<ScApplicationProperty>> find(String applicationId) {
        ScApplicationProperty query = new ScApplicationProperty();
        query.setApplicationId(applicationId);
        return super.select(query);
    }

    @Override
    public Result<ScApplicationProperty> save(ScApplicationProperty scApplicationProperty) {
        String methodCode = "save";
        if (StringHelper.isEmpty(scApplicationProperty.getApplicationId()))
            return new Result<>(serviceCode, methodCode, 501);
        if (StringHelper.isEmpty(scApplicationProperty.getPropertyId()))
            return new Result<>(serviceCode, methodCode, 502);
        if (StringHelper.isEmpty(scApplicationProperty.getPropertyValue()))
            return new Result<>(serviceCode, methodCode, 503);
        return super.insert(scApplicationProperty);
    }

    @Override
    public Result update(ScApplicationProperty scApplicationProperty) {
        String methodCode = "update";
        if (scApplicationProperty.getId() == null) {
            return new Result<>(serviceCode, methodCode, 501);
        }
        return super.update(scApplicationProperty);
    }

    @Override
    public Result<PageInfo<ScApplicationProperty>> findByPage(ScApplicationProperty scApplicationProperty, Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageNum <= 0)
            pageNum = 1;
        if (pageSize == null || pageSize <= 0)
            pageSize = 10;
        Weekend<ScApplicationProperty> weekend = Weekend.of(ScApplicationProperty.class);
        WeekendCriteria<ScApplicationProperty, Object> criteria = weekend.weekendCriteria();
        if (StringHelper.isNotEmpty(scApplicationProperty.getApplicationId())) {
            String applicationId = "%" + scApplicationProperty.getApplicationId() + "%";
            criteria.andLike(ScApplicationProperty::getApplicationId, applicationId);
            //criteria.andEqualTo(ScApplicationProperty::getApplicationId, scApplicationProperty.getApplicationId());
        }
        if (StringHelper.isNotEmpty(scApplicationProperty.getPropertyId())) {
            String propertyId = "%" + scApplicationProperty.getPropertyId() + "%";
            criteria.andLike(ScApplicationProperty::getPropertyId, propertyId);
            //criteria.andEqualTo(ScApplicationProperty::getPropertyId, scApplicationProperty.getPropertyId());
        }
        weekend.orderBy("createTime").desc();
        return super.selectForPage(weekend, pageNum, pageSize);
    }

}
