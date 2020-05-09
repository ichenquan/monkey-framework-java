package monkey.config.bus.server.service.provider;

import monkey.common.DbServiceImpl;
import monkey.common.Result;
import monkey.common.StringHelper;
import monkey.config.bus.data.model.ScApplication;
import monkey.config.bus.data.model.ScApplicationProperty;
import monkey.config.bus.server.service.contract.ScApplicationPropertyService;
import monkey.config.bus.server.service.contract.ScApplicationService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.NonNull;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.Date;
import java.util.List;


@Service
public class ScApplicationServiceImpl extends DbServiceImpl<ScApplication> implements ScApplicationService {

    private String serviceCode = "sc_application";
    @Autowired
    private ScApplicationPropertyService scApplicationPropertyService;

    @Override
    public Result<ScApplication> save(ScApplication scApplication) {
        String methodCode = "save";
        if (StringHelper.isEmpty(scApplication.getApplicationId())){ return new Result<>(serviceCode, methodCode, 501);}
        Result<ScApplication> save = super.insert(scApplication);
        if (save.isSuccess() && save.hasData()){
            ScApplicationProperty property = new ScApplicationProperty();
            long id = this.objectIdGenerator.newId();
            property.setId(id);
            property.setCreateTime(new Date());
            property.setFlag(0);
            property.setApplicationId(scApplication.getApplicationId());
            scApplicationPropertyService.save(property);
        }

        return save;
    }

    @Override
    public Result update(@NonNull ScApplication scApplication) {
        String methodCode = "update";
        if (scApplication.getId() == null){ return new Result<>(serviceCode, methodCode, 501);}
        ScApplication application = super.selectByPrimaryKey(scApplication.getId()).getData();
        if (application == null){return new Result<>(serviceCode, methodCode, 502);}
        String applicationId = application.getApplicationId();
        if (StringHelper.isNotEmpty(scApplication.getApplicationId())){
            application.setApplicationId(scApplication.getApplicationId());
        }
        if (scApplication.getFlag() != null){
            application.setFlag(scApplication.getFlag());
        }
        Result update =  super.update(scApplication);
        if (update.isSuccess()){
            List<ScApplicationProperty> properties = scApplicationPropertyService.find(applicationId).getData();
            for (ScApplicationProperty p : properties) {

                if (StringHelper.isNotEmpty(scApplication.getApplicationId())){
                    p.setApplicationId(scApplication.getApplicationId());
                }
                if (scApplication.getFlag() != null){
                    p.setFlag(scApplication.getFlag());
                }
                scApplicationPropertyService.update(p);
            }
        }
        return update;
    }

    @Override
    public Result<PageInfo<ScApplication>> findByPage(ScApplication scApplication, Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 10;
        }
        Weekend<ScApplication> weekend = Weekend.of(ScApplication.class);
        WeekendCriteria<ScApplication, Object> criteria = weekend.weekendCriteria();
        if (StringHelper.isNotEmpty(scApplication.getApplicationId())) {
            String applicationId = "%" + scApplication.getApplicationId() + "%";
            criteria.andLike(ScApplication::getApplicationId, applicationId);
            //criteria.andEqualTo(ScApplication::getApplicationId, scApplication.getApplicationId());
        }
        weekend.orderBy("createTime").desc();
        return super.selectForPage(weekend, pageNum, pageSize);
    }

    @Override
    public Result<ScApplication> copyProperty(String applicationId, String newApplicationId, String remark) {
        String methodCode = "copyProperty";
        if (StringHelper.isEmpty(applicationId)){ return new Result<>(serviceCode, methodCode, 501);}
        if (StringHelper.isEmpty(newApplicationId)){ return new Result<>(serviceCode, methodCode, 502);}

        List<ScApplication> applicationList = super.selectAll().getData();
        for (ScApplication application : applicationList) {
            if (newApplicationId.equals(application.getApplicationId())) {
                //应用ID已存在
                return new Result<>(serviceCode, methodCode, 503);
            }
        }

        ScApplication scApplication = new ScApplication();
        scApplication.setApplicationId(newApplicationId);
        scApplication.setRemark(remark);
        Result<ScApplication> result = save(scApplication);
        if (result.isSuccess()) {
            List<ScApplicationProperty> properties = scApplicationPropertyService.find(applicationId).getData();
            for (ScApplicationProperty property : properties) {
                ScApplicationProperty p = new ScApplicationProperty();
                p.setApplicationId(newApplicationId);
                p.setPropertyId(property.getPropertyId());
                p.setPropertyValue(property.getPropertyValue());
                p.setRemark(property.getRemark());
                scApplicationPropertyService.save(p);
            }
        }
        return result;
    }

    @Override
    public Result<List<ScApplication>> getAll() {
        return super.selectAll();
    }
}
