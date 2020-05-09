package monkey.config.bus.data.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "sc_service_channel")
public class ScServiceChannel implements Serializable {
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
     * 服务主机
     */
    @Column(name = "service_host")
    private String serviceHost;

    /**
     * 服务名称
     */
    @Column(name = "service_name")
    private String serviceName;

    /**
     * 服务名称
     */
    @Column(name = "service_port")
    private String servicePort;

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
     * 获取服务主机
     *
     * @return service_host - 服务主机
     */
    public String getServiceHost() {
        return serviceHost;
    }

    /**
     * 设置服务主机
     *
     * @param serviceHost 服务主机
     */
    public void setServiceHost(String serviceHost) {
        this.serviceHost = serviceHost;
    }

    /**
     * 获取服务名称
     *
     * @return service_names - 服务名称
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * 设置服务名称
     *
     * @param serviceName 服务名称
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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
        sb.append(", serviceHost=").append(serviceHost);
        sb.append(", serviceName=").append(serviceName);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public String getServicePort() {
        return servicePort;
    }

    public void setServicePort(String servicePort) {
        this.servicePort = servicePort;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
}