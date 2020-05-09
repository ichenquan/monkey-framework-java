package monkey.common;

import org.apache.ibatis.annotations.UpdateProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.Map;

/**
 * Description:
 * Author: ChenQ
 * Date: 2020/4/28
 */
@RegisterMapper
public interface DbUpdateBatchMapper<T> {
    @UpdateProvider(
            type = DbUpdateBatchExecutor.class,
            method = "dynamicSQL"
    )
    int updateBatch(Map<String, Object> map);
}
