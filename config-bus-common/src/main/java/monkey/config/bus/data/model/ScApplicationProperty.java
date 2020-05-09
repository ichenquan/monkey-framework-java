package monkey.config.bus.data.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "sc_application_property")
public class ScApplicationProperty implements Serializable {
    /**
     * 唯一ID
     */
    @Id
    private Long id;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 逻辑删除标志位
     */
    private Integer flag;

    /**
     * 应用程序ID
     */
    @Column(name = "application_id")
    private String applicationId;

    /**
     * 属性ID
     */
    @Column(name = "property_id")
    private String propertyId;

    /**
     * 属性值
     */
    @Column(name = "property_value")
    private String propertyValue;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * 获取唯一ID
     *
     * @return id - 唯一ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置唯一ID
     *
     * @param id 唯一ID
     */
    public void setId(Long id) {
        this.id = id;
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
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取逻辑删除标志位
     *
     * @return flag - 逻辑删除标志位
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * 设置逻辑删除标志位
     *
     * @param flag 逻辑删除标志位
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * 获取应用程序ID
     *
     * @return application_id - 应用程序ID
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * 设置应用程序ID
     *
     * @param applicationId 应用程序ID
     */
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * 获取属性ID
     *
     * @return property_id - 属性ID
     */
    public String getPropertyId() {
        return propertyId;
    }

    /**
     * 设置属性ID
     *
     * @param propertyId 属性ID
     */
    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    /**
     * 获取属性值
     *
     * @return property_value - 属性值
     */
    public String getPropertyValue() {
        return propertyValue;
    }

    /**
     * 设置属性值
     *
     * @param propertyValue 属性值
     */
    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
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
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", flag=").append(flag);
        sb.append(", applicationId=").append(applicationId);
        sb.append(", propertyId=").append(propertyId);
        sb.append(", propertyValue=").append(propertyValue);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}