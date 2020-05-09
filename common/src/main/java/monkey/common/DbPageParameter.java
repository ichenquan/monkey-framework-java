package monkey.common;

import tk.mybatis.mapper.entity.IDynamicTableName;

import javax.persistence.Transient;

/**
 * Description: 分页参数
 * Author: ChenQ
 * Date:  2020/4/28
 */
public class DbPageParameter extends DbLimitParameter implements IDynamicTableName {

    @Transient
    private Integer pageNum;
    @Transient
    private Integer pageSize;
    @Transient
    private String dynamicTableName;
    @Transient
    private Integer beginIndex;
    @Transient
    private Integer total;

    @Override
    public String getDynamicTableName() {
        return dynamicTableName;
    }

    public void setDynamicTableName(String dynamicTableName) {
        this.dynamicTableName = dynamicTableName;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getBeginIndex() {
        return beginIndex;
    }

    public void setBeginIndex(Integer beginIndex) {
        this.beginIndex = beginIndex;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
