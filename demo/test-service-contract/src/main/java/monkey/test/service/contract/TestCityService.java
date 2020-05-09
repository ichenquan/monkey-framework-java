package monkey.test.service.contract;

import monkey.common.Result;
import monkey.test.data.model.TestCity;

import java.util.List;

public interface TestCityService {

    Result save(TestCity created);

    Result delete(Long id);

    Result update(TestCity changed);

    Result<List<TestCity>> get();
}
