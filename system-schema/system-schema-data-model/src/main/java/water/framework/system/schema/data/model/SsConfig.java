package water.framework.system.schema.data.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import monkey.common.DbPageParameter;

@Table(name = "ss_config")
public class SsConfig extends DbPageParameter implements Serializable {
    /**
     * 参数主键
     */
    @Id
    private Integer id;

    /**
     * 参数名称
     */
    @Column(name = "config_name")
    private String configName;

    /**
     * 参数键名
     */
    @Column(name = "config_key")
    private String configKey;

    /**
     * 参数键值
     */
    @Column(name = "config_value")
    private String configValue;

    /**
     * 系统内置（Y是 N否）
     */
    @Column(name = "config_type")
    private String configType;

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
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * 获取参数主键
     *
     * @return id - 参数主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置参数主键
     *
     * @param id 参数主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取参数名称
     *
     * @return config_name - 参数名称
     */
    public String getConfigName() {
        return configName;
    }

    /**
     * 设置参数名称
     *
     * @param configName 参数名称
     */
    public void setConfigName(String configName) {
        this.configName = configName;
    }

    /**
     * 获取参数键名
     *
     * @return config_key - 参数键名
     */
    public String getConfigKey() {
        return configKey;
    }

    /**
     * 设置参数键名
     *
     * @param configKey 参数键名
     */
    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    /**
     * 获取参数键值
     *
     * @return config_value - 参数键值
     */
    public String getConfigValue() {
        return configValue;
    }

    /**
     * 设置参数键值
     *
     * @param configValue 参数键值
     */
    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    /**
     * 获取系统内置（Y是 N否）
     *
     * @return config_type - 系统内置（Y是 N否）
     */
    public String getConfigType() {
        return configType;
    }

    /**
     * 设置系统内置（Y是 N否）
     *
     * @param configType 系统内置（Y是 N否）
     */
    public void setConfigType(String configType) {
        this.configType = configType;
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
        sb.append(", configName=").append(configName);
        sb.append(", configKey=").append(configKey);
        sb.append(", configValue=").append(configValue);
        sb.append(", configType=").append(configType);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}