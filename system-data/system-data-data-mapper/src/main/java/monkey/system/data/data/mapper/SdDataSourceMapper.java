package monkey.system.data.data.mapper;

import monkey.common.DbMapper;
import monkey.system.data.data.model.SdDataSource;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface SdDataSourceMapper extends DbMapper<SdDataSource> {
}