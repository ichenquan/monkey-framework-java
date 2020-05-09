package monkey.config.bus.data.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "sc_db_node")
public class ScDbNode implements Serializable {
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
     * 集群ID
     */
    @Column(name = "cluster_id")
    private String clusterId;

    /**
     * 节点ID
     */
    @Column(name = "node_id")
    private String nodeId;

    /**
     * 类型标识
     */
    @Column(name = "type_id")
    private String typeId;

    /**
     * URL
     */
    private String url;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     */
    private String password;

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
     * 获取集群ID
     *
     * @return cluster_id - 集群ID
     */
    public String getClusterId() {
        return clusterId;
    }

    /**
     * 设置集群ID
     *
     * @param clusterId 集群ID
     */
    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    /**
     * 获取节点ID
     *
     * @return node_id - 节点ID
     */
    public String getNodeId() {
        return nodeId;
    }

    /**
     * 设置节点ID
     *
     * @param nodeId 节点ID
     */
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * 获取类型标识
     *
     * @return type_id - 类型标识
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * 设置类型标识
     *
     * @param typeId 类型标识
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取URL
     *
     * @return url - URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置URL
     *
     * @param url URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
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
        sb.append(", clusterId=").append(clusterId);
        sb.append(", nodeId=").append(nodeId);
        sb.append(", typeId=").append(typeId);
        sb.append(", url=").append(url);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}