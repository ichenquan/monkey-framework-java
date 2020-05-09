package monkey.system.data.data.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import monkey.common.DbPageParameter;

@Table(name = "sd_designer_column")
public class SdDesignerColumn extends DbPageParameter implements Serializable {
    /**
     * 编号
     */
    @Id
    private Long id;

    /**
     * 归属表编号
     */
    @Column(name = "table_id")
    private String tableId;

    /**
     * 列名称
     */
    private String name;

    /**
     * 列描述
     */
    private String comment;

    /**
     * 列类型
     */
    private String type;

    /**
     * 是否主键（1是）
     */
    @Column(name = "is_pk")
    private String isPk;

    /**
     * 是否自增（1是）
     */
    @Column(name = "is_increment")
    private String isIncrement;

    /**
     * 是否必填（1是）
     */
    @Column(name = "is_required")
    private String isRequired;

    /**
     * 是否为插入字段（1是）
     */
    @Column(name = "is_insert")
    private String isInsert;

    /**
     * 是否编辑字段（1是）
     */
    @Column(name = "is_edit")
    private String isEdit;

    /**
     * 是否列表字段（1是）
     */
    @Column(name = "is_list")
    private String isList;

    /**
     * 是否查询字段（1是）
     */
    @Column(name = "is_query")
    private String isQuery;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建者
     */
    @Column(name = "create_user_id")
    private Long createUserId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新者
     */
    @Column(name = "update_user_id")
    private Long updateUserId;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 标志（0-正常，1-已删除，2-只读）
     */
    private String flag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取归属表编号
     *
     * @return table_id - 归属表编号
     */
    public String getTableId() {
        return tableId;
    }

    /**
     * 设置归属表编号
     *
     * @param tableId 归属表编号
     */
    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    /**
     * 获取列名称
     *
     * @return name - 列名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置列名称
     *
     * @param name 列名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取列描述
     *
     * @return comment - 列描述
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置列描述
     *
     * @param comment 列描述
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取列类型
     *
     * @return type - 列类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置列类型
     *
     * @param type 列类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取是否主键（1是）
     *
     * @return is_pk - 是否主键（1是）
     */
    public String getIsPk() {
        return isPk;
    }

    /**
     * 设置是否主键（1是）
     *
     * @param isPk 是否主键（1是）
     */
    public void setIsPk(String isPk) {
        this.isPk = isPk;
    }

    /**
     * 获取是否自增（1是）
     *
     * @return is_increment - 是否自增（1是）
     */
    public String getIsIncrement() {
        return isIncrement;
    }

    /**
     * 设置是否自增（1是）
     *
     * @param isIncrement 是否自增（1是）
     */
    public void setIsIncrement(String isIncrement) {
        this.isIncrement = isIncrement;
    }

    /**
     * 获取是否必填（1是）
     *
     * @return is_required - 是否必填（1是）
     */
    public String getIsRequired() {
        return isRequired;
    }

    /**
     * 设置是否必填（1是）
     *
     * @param isRequired 是否必填（1是）
     */
    public void setIsRequired(String isRequired) {
        this.isRequired = isRequired;
    }

    /**
     * 获取是否为插入字段（1是）
     *
     * @return is_insert - 是否为插入字段（1是）
     */
    public String getIsInsert() {
        return isInsert;
    }

    /**
     * 设置是否为插入字段（1是）
     *
     * @param isInsert 是否为插入字段（1是）
     */
    public void setIsInsert(String isInsert) {
        this.isInsert = isInsert;
    }

    /**
     * 获取是否编辑字段（1是）
     *
     * @return is_edit - 是否编辑字段（1是）
     */
    public String getIsEdit() {
        return isEdit;
    }

    /**
     * 设置是否编辑字段（1是）
     *
     * @param isEdit 是否编辑字段（1是）
     */
    public void setIsEdit(String isEdit) {
        this.isEdit = isEdit;
    }

    /**
     * 获取是否列表字段（1是）
     *
     * @return is_list - 是否列表字段（1是）
     */
    public String getIsList() {
        return isList;
    }

    /**
     * 设置是否列表字段（1是）
     *
     * @param isList 是否列表字段（1是）
     */
    public void setIsList(String isList) {
        this.isList = isList;
    }

    /**
     * 获取是否查询字段（1是）
     *
     * @return is_query - 是否查询字段（1是）
     */
    public String getIsQuery() {
        return isQuery;
    }

    /**
     * 设置是否查询字段（1是）
     *
     * @param isQuery 是否查询字段（1是）
     */
    public void setIsQuery(String isQuery) {
        this.isQuery = isQuery;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取创建者
     *
     * @return create_user_id - 创建者
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置创建者
     *
     * @param createUserId 创建者
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新者
     *
     * @return update_user_id - 更新者
     */
    public Long getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 设置更新者
     *
     * @param updateUserId 更新者
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取标志（0-正常，1-已删除，2-只读）
     *
     * @return flag - 标志（0-正常，1-已删除，2-只读）
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 设置标志（0-正常，1-已删除，2-只读）
     *
     * @param flag 标志（0-正常，1-已删除，2-只读）
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tableId=").append(tableId);
        sb.append(", name=").append(name);
        sb.append(", comment=").append(comment);
        sb.append(", type=").append(type);
        sb.append(", isPk=").append(isPk);
        sb.append(", isIncrement=").append(isIncrement);
        sb.append(", isRequired=").append(isRequired);
        sb.append(", isInsert=").append(isInsert);
        sb.append(", isEdit=").append(isEdit);
        sb.append(", isList=").append(isList);
        sb.append(", isQuery=").append(isQuery);
        sb.append(", sort=").append(sort);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", flag=").append(flag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}