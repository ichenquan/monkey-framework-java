package monkey.test.data.mapper;

import monkey.common.DbMapper;
import monkey.test.data.model.TestCity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TestCityMapper extends DbMapper<TestCity> {
}