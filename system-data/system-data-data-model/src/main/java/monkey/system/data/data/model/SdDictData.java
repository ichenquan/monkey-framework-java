package monkey.system.data.data.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import monkey.common.DbPageParameter;

@Table(name = "sd_dict_data")
public class SdDictData extends DbPageParameter implements Serializable {
    /**
     * 字典编码
     */
    @Id
    @Column(name = "dict_code")
    private Long dictCode;

    /**
     * 字典排序
     */
    @Column(name = "dict_sort")
    private Integer dictSort;

    /**
     * 字典标签
     */
    @Column(name = "dict_label")
    private String dictLabel;

    /**
     * 字典键值
     */
    @Column(name = "dict_value")
    private String dictValue;

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
     * 样式属性（其他样式扩展）
     */
    @Column(name = "css_class")
    private String cssClass;

    /**
     * 表格回显样式
     */
    @Column(name = "list_class")
    private String listClass;

    /**
     * 是否默认（Y是 N否）
     */
    @Column(name = "is_default")
    private String isDefault;

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
     * 获取字典编码
     *
     * @return dict_code - 字典编码
     */
    public Long getDictCode() {
        return dictCode;
    }

    /**
     * 设置字典编码
     *
     * @param dictCode 字典编码
     */
    public void setDictCode(Long dictCode) {
        this.dictCode = dictCode;
    }

    /**
     * 获取字典排序
     *
     * @return dict_sort - 字典排序
     */
    public Integer getDictSort() {
        return dictSort;
    }

    /**
     * 设置字典排序
     *
     * @param dictSort 字典排序
     */
    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }

    /**
     * 获取字典标签
     *
     * @return dict_label - 字典标签
     */
    public String getDictLabel() {
        return dictLabel;
    }

    /**
     * 设置字典标签
     *
     * @param dictLabel 字典标签
     */
    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    /**
     * 获取字典键值
     *
     * @return dict_value - 字典键值
     */
    public String getDictValue() {
        return dictValue;
    }

    /**
     * 设置字典键值
     *
     * @param dictValue 字典键值
     */
    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
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
     * 获取样式属性（其他样式扩展）
     *
     * @return css_class - 样式属性（其他样式扩展）
     */
    public String getCssClass() {
        return cssClass;
    }

    /**
     * 设置样式属性（其他样式扩展）
     *
     * @param cssClass 样式属性（其他样式扩展）
     */
    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    /**
     * 获取表格回显样式
     *
     * @return list_class - 表格回显样式
     */
    public String getListClass() {
        return listClass;
    }

    /**
     * 设置表格回显样式
     *
     * @param listClass 表格回显样式
     */
    public void setListClass(String listClass) {
        this.listClass = listClass;
    }

    /**
     * 获取是否默认（Y是 N否）
     *
     * @return is_default - 是否默认（Y是 N否）
     */
    public String getIsDefault() {
        return isDefault;
    }

    /**
     * 设置是否默认（Y是 N否）
     *
     * @param isDefault 是否默认（Y是 N否）
     */
    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
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
        sb.append(", dictCode=").append(dictCode);
        sb.append(", dictSort=").append(dictSort);
        sb.append(", dictLabel=").append(dictLabel);
        sb.append(", dictValue=").append(dictValue);
        sb.append(", dictType=").append(dictType);
        sb.append(", ownedDeptId=").append(ownedDeptId);
        sb.append(", cssClass=").append(cssClass);
        sb.append(", listClass=").append(listClass);
        sb.append(", isDefault=").append(isDefault);
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