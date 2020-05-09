package monkey.common;

import org.apache.ibatis.annotations.InsertProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

/**
 * Description:
 * Author: ChenQ
 * Date: 2020/4/28
 */
@RegisterMapper
public interface DbInsertBatchMapper<T> {
    @InsertProvider(
            type = DbInsertBatchExecutor.class,
            method = "dynamicSQL"
    )
    int insertBatch(List<T> list);
}
