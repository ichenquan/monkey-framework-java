package monkey.system.data.data.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import monkey.common.DbPageParameter;

@Table(name = "sd_designer_table")
public class SdDesignerTable extends DbPageParameter implements Serializable {
    /**
     * 编号
     */
    @Id
    private Long id;

    /**
     * 表名称
     */
    private String name;

    /**
     * 表描述
     */
    private String comment;

    /**
     * 使用的模板（crud单表操作 tree树表操作）
     */
    @Column(name = "tpl_category")
    private String tplCategory;

    /**
     * 其它生成选项
     */
    private String options;

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

    /**
     * 备注
     */
    private String remark;

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
     * 获取表名称
     *
     * @return name - 表名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置表名称
     *
     * @param name 表名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取表描述
     *
     * @return comment - 表描述
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置表描述
     *
     * @param comment 表描述
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取使用的模板（crud单表操作 tree树表操作）
     *
     * @return tpl_category - 使用的模板（crud单表操作 tree树表操作）
     */
    public String getTplCategory() {
        return tplCategory;
    }

    /**
     * 设置使用的模板（crud单表操作 tree树表操作）
     *
     * @param tplCategory 使用的模板（crud单表操作 tree树表操作）
     */
    public void setTplCategory(String tplCategory) {
        this.tplCategory = tplCategory;
    }

    /**
     * 获取其它生成选项
     *
     * @return options - 其它生成选项
     */
    public String getOptions() {
        return options;
    }

    /**
     * 设置其它生成选项
     *
     * @param options 其它生成选项
     */
    public void setOptions(String options) {
        this.options = options;
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

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", comment=").append(comment);
        sb.append(", tplCategory=").append(tplCategory);
        sb.append(", options=").append(options);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", flag=").append(flag);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}