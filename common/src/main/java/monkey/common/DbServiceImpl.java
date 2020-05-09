package monkey.common;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageRowBounds;
import lombok.NonNull;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbServiceImpl<T> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DbMapper<T> mapper;
    @Autowired
    protected ObjectIdGenerator objectIdGenerator;

    protected String idMethod = "setId";
    protected String getIdMethod = "getId";
    protected String flagMethod = "setFlag";
    protected String updateTimeMethod = "setUpdateTime";
    protected String createTimeMethod = "setCreateTime";
    protected String createTimeField = "createTime";

    protected Result<T> insert(@NonNull T t) {
        t = setDefaultFieldValues(t);
        int i = mapper.insert(t);
        if (i == 1) {
            return new Result<>(t);
        }
        return new Result<>(500);
    }

    protected T setDefaultFieldValues(@NonNull T t) {
        long id = objectIdGenerator.newId();
        setFieldValue(t, this.idMethod, id);
        setFieldValue(t, this.flagMethod, 1);
        setFieldValue(t, this.createTimeMethod, Calendar.getInstance().getTime());
        return t;
    }

    protected Result<Long> insertSample(@NonNull T t) {
        int i = mapper.insert(t);
        if (i == 1) {
            return new Result<>();
        }
        return new Result<Long>(500);
    }

    protected Result insertBatch(@NonNull List<T> list) {
        int i = mapper.insertBatch(list);
        if (i >= 1) {
            return new Result();
        }
        return new Result(500);
    }

    protected Result update(@NonNull T t) {
        setFieldValue(t, this.updateTimeMethod, Calendar.getInstance().getTime());
        int i = mapper.updateByPrimaryKeySelective(t);
        if (i == 1) {
            return new Result();
        }
        return new Result(500);
    }


    protected Result updateByExample(@NonNull T t, @NonNull Example example) {
        setFieldValue(t, this.updateTimeMethod, Calendar.getInstance().getTime());
        int i = mapper.updateByExampleSelective(t, example);
        if (i == 1) {
            return new Result();
        }
        return new Result(500);
    }

    protected Result updateBatch(@NonNull List<T> list) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        int i = mapper.updateBatch(map);
        if (i >= 1) {
            return new Result();
        }
        return new Result(500);
    }

    protected Result delete(@NonNull T t) {
        setFieldValue(t, this.flagMethod, 0);
        int i = mapper.updateByPrimaryKeySelective(t);
        if (i == 1) {
            return new Result();
        }
        return new Result(500);
    }

    protected Result destroy(@NonNull T t) {
        int i = mapper.delete(t);
        if (i == 1) {
            return new Result();
        }
        return new Result(500);
    }

    protected Result<T> selectByPrimaryKey(@NonNull Long id) {
        return new Result<>(mapper.selectByPrimaryKey(id));
    }

    protected Result<Integer> selectCount(T query) {
        setFieldValue(query, this.flagMethod, 1);
        int count = mapper.selectCount(query);
        return new Result<>(200, count);
    }

    protected Result<Integer> selectCountByExample(Weekend<T> weekend) {
        int count = mapper.selectCountByExample(weekend);
        return new Result<>(200, count);
    }

    /**
     * Description: 单个查询，所有查询默认查询flag=1的数据
     * Author: ChenQ
     * Date: 2020/4/28
     */
    protected Result<T> selectOne(@NonNull T query) {
        setFieldValue(query, this.flagMethod, 1);
        return new Result<>(mapper.selectOne(query));
    }

    /**
     * Description: 列表查询，默认按照createTime字段倒序查询
     * Author: ChenQ
     * Date: 2020/4/28
     */
    protected Result<List<T>> select(@NonNull T query) {
        setFieldValue(query, this.flagMethod, 1);
        return select(query, this.createTimeField);
    }

    /**
     * Description: 列表查询，根据指定的字段倒序排序
     * Author: ChenQ
     * Date: 2020/4/28
     */
    protected Result<List<T>> select(@NonNull T query, @NonNull String orderField) {
        setFieldValue(query, this.flagMethod, 1);
        Weekend<T> weekend = getWeekend(query, orderField);
        if (weekend == null) {
            return new Result<List<T>>(500);
        }
        List<T> result = mapper.selectByExample(weekend);
        return new Result<>(result);
    }

    protected Result<List<T>> selectByExample(Example example) {
        return new Result<>(mapper.selectByExample(example));
    }

    protected Result<List<T>> selectAll() {
        return new Result<>(mapper.selectAll());
    }

    /**
     * Description: 分页查询，默认按照createTime字段倒序查询
     * Author: ChenQ
     * Date: 2020/4/28
     */
    protected Result<PageInfo<T>> selectForPage(@NonNull T query, @NonNull int pageNum, @NonNull int pageSize) {
        setFieldValue(query, this.flagMethod, 1);
        return selectForPage(query, pageNum, pageSize, this.createTimeField);
    }

    /**
     * Description: 分页查询，根据指定的字段倒序排序
     * Author: ChenQ
     * Date: 2020/4/28
     */
    protected Result<PageInfo<T>> selectForPage(@NonNull T query, @NonNull int pageNum, @NonNull int pageSize, @NonNull String orderField) {
        setFieldValue(query, this.flagMethod, 1);
        if (pageNum < 1) {
            pageNum = 1;
        }
        if (pageSize < 1) {
            pageSize = 1;
        }
        Weekend<T> weekend = getWeekend(query, orderField);
        if (weekend == null) {
            return new Result<PageInfo<T>>(500);
        }
        PageRowBounds pageRowBounds = new PageRowBounds((pageNum - 1) * pageSize, pageSize);
        List<T> result = mapper.selectByExampleAndRowBounds(weekend, pageRowBounds);
        PageInfo<T> pageInfo = new PageInfo<>(result);
        return new Result<>(pageInfo);
    }

    /**
     * Description: 分页查询，默认按照createTime字段倒序查询
     * Author: ChenQ
     * Date: 2020/4/28
     */
    protected Result<PageInfo<T>> selectForPage(@NonNull Weekend<T> weekend, @NonNull int pageNum, @NonNull int pageSize) {
        return selectForPage(weekend, pageNum, pageSize, this.createTimeField, true);
    }

    /**
     * Description: 分页查询，根据指定的字段排序
     * Author: ChenQ
     * Date: 2020/4/28
     */
    protected Result<PageInfo<T>> selectForPage(@NonNull Weekend<T> weekend, @NonNull int pageNum, @NonNull int pageSize, @NonNull String orderField,
                                                @NonNull boolean isDesc) {
        if (pageNum < 1) {
            pageNum = 1;
        }
        if (pageSize < 1) {
            pageSize = 1;
        }
        if (isDesc) {
            weekend.orderBy(orderField).desc();
        } else {
            weekend.orderBy(orderField).asc();
        }
        PageRowBounds pageRowBounds = new PageRowBounds((pageNum - 1) * pageSize, pageSize);
        List<T> result = mapper.selectByExampleAndRowBounds(weekend, pageRowBounds);
        PageInfo<T> pageInfo = new PageInfo<>(result);
        return new Result<>(pageInfo);
    }

    protected void setFieldValue(T obj, String fieldName, Object value) {
        Class<?> clazz = obj.getClass();
        try {
            Method method = clazz.getMethod(fieldName, value.getClass());
            if (method == null) {
                return;
            }
            if (fieldName.equals(idMethod)) {
                Method getMethod = clazz.getMethod(getIdMethod);
                Object id = getMethod.invoke(obj);
                if (id == null) {
                    method.invoke(obj, value);
                }
            } else {
                method.invoke(obj, value);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            logger.error(e.getMessage(), e);
        }
    }

    protected Weekend<T> getWeekend(T query, String orderField) {
        Weekend<T> weekend = new Weekend<>((Class<T>) query.getClass(), Boolean.TRUE.booleanValue());
        weekend.orderBy(orderField).desc();
        WeekendCriteria<?, Object> criteria = weekend.weekendCriteria();
        try {
            Map<String, Object> describe = PropertyUtils.describe(query);
            for (Map.Entry<String, Object> entry : describe.entrySet()) {
                Object value = entry.getValue();
                if (value == null || StringHelper.isEmpty(value.toString())) {
                    continue;
                }
                if (value instanceof Class) {
                    continue;
                }
                if ("pageNum".equals(entry.getKey())) {
                    continue;
                }
                if ("pageSize".equals(entry.getKey())) {
                    continue;
                }
                if ("total".equals(entry.getKey())) {
                    continue;
                }
                if ("beginIndex".equals(entry.getKey())) {
                    continue;
                }
                if ("maxSize".equals(entry.getKey())) {
                    continue;
                }
                criteria.andEqualTo(entry.getKey(), value);
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
        return weekend;
    }

}
