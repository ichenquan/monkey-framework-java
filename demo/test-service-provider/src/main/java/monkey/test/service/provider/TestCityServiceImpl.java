package monkey.test.service.provider;

import monkey.common.DbServiceImpl;
import monkey.common.Result;
import monkey.test.data.model.TestCity;
import monkey.test.service.contract.TestCityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCityServiceImpl extends DbServiceImpl<TestCity> implements TestCityService {

    @Override
    public Result save(TestCity created) {
        return super.insert(created);
    }

    @Override
    public Result delete(Long id) {
        TestCity city = new TestCity();
        city.setId(id);
        return super.delete(city);
    }

    @Override
    public Result update(TestCity changed) {
        return super.update(changed);
    }

    @Override
    public Result<List<TestCity>> get() {
        return super.selectAll();
    }
}
