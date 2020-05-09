package monkey.config.bus.data.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "sc_db_path")
public class ScDbPath implements Serializable {
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
     * mysql集群ID
     */
    @Column(name = "cluster_id")
    private String clusterId;

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
     * 获取mysql集群ID
     *
     * @return cluster_id - mysql集群ID
     */
    public String getClusterId() {
        return clusterId;
    }

    /**
     * 设置mysql集群ID
     *
     * @param clusterId mysql集群ID
     */
    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
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
        sb.append(", clusterId=").append(clusterId);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}