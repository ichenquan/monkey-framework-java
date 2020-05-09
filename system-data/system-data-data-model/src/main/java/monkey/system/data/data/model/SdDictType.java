package monkey.system.data.data.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import monkey.common.DbPageParameter;

@Table(name = "sd_dict_type")
public class SdDictType extends DbPageParameter implements Serializable {
    /**
     * 字典主键
     */
    @Id
    private Long id;

    /**
     * 字典名称
     */
    @Column(name = "dict_name")
    private String dictName;

    /**
     * 字典类型
     */
    @Column(name = "dict_type")
    private String dictType;

    /**
     * 拥有者的（父）机构标识
     */
    @Column(name = "owned_dept_id")
    private Long ownedDeptId;

    /**
     * 状态（0正常 1停用）
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

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
     * 获取字典主键
     *
     * @return id - 字典主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置字典主键
     *
     * @param id 字典主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取字典名称
     *
     * @return dict_name - 字典名称
     */
    public String getDictName() {
        return dictName;
    }

    /**
     * 设置字典名称
     *
     * @param dictName 字典名称
     */
    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    /**
     * 获取字典类型
     *
     * @return dict_type - 字典类型
     */
    public String getDictType() {
        return dictType;
    }

    /**
     * 设置字典类型
     *
     * @param dictType 字典类型
     */
    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    /**
     * 获取拥有者的（父）机构标识
     *
     * @return owned_dept_id - 拥有者的（父）机构标识
     */
    public Long getOwnedDeptId() {
        return ownedDeptId;
    }

    /**
     * 设置拥有者的（父）机构标识
     *
     * @param ownedDeptId 拥有者的（父）机构标识
     */
    public void setOwnedDeptId(Long ownedDeptId) {
        this.ownedDeptId = ownedDeptId;
    }

    /**
     * 获取状态（0正常 1停用）
     *
     * @return status - 状态（0正常 1停用）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0正常 1停用）
     *
     * @param status 状态（0正常 1停用）
     */
    public void setStatus(String status) {
        this.status = status;
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
        sb.append(", dictName=").append(dictName);
        sb.append(", dictType=").append(dictType);
        sb.append(", ownedDeptId=").append(ownedDeptId);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
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