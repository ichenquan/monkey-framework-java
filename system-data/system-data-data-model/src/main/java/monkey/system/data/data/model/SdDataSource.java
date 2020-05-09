package monkey.system.data.data.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import monkey.common.DbPageParameter;

@Table(name = "sd_data_source")
public class SdDataSource extends DbPageParameter implements Serializable {
    /**
     * 数据源主键
     */
    @Id
    private Long id;

    /**
     * 数据源编码
     */
    @Column(name = "data_source_code")
    private String dataSourceCode;

    /**
     * 数据源连接串
     */
    @Column(name = "data_source_url")
    private String dataSourceUrl;

    /**
     * 数据源用户
     */
    @Column(name = "data_source_user")
    private String dataSourceUser;

    /**
     * 数据源密码
     */
    @Column(name = "data_source_pwd")
    private String dataSourcePwd;

    /**
     * Jdbc驱动包名
     */
    @Column(name = "jdbc_driver_type")
    private String jdbcDriverType;

    /**
     * 租户标识
     */
    @Column(name = "tenant_id")
    private String tenantId;

    /**
     * 租户类型（0-database，1-schema，2-discriminator）
     */
    @Column(name = "tenant_type")
    private String tenantType;

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
     * 获取数据源主键
     *
     * @return id - 数据源主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置数据源主键
     *
     * @param id 数据源主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取数据源编码
     *
     * @return data_source_code - 数据源编码
     */
    public String getDataSourceCode() {
        return dataSourceCode;
    }

    /**
     * 设置数据源编码
     *
     * @param dataSourceCode 数据源编码
     */
    public void setDataSourceCode(String dataSourceCode) {
        this.dataSourceCode = dataSourceCode;
    }

    /**
     * 获取数据源连接串
     *
     * @return data_source_url - 数据源连接串
     */
    public String getDataSourceUrl() {
        return dataSourceUrl;
    }

    /**
     * 设置数据源连接串
     *
     * @param dataSourceUrl 数据源连接串
     */
    public void setDataSourceUrl(String dataSourceUrl) {
        this.dataSourceUrl = dataSourceUrl;
    }

    /**
     * 获取数据源用户
     *
     * @return data_source_user - 数据源用户
     */
    public String getDataSourceUser() {
        return dataSourceUser;
    }

    /**
     * 设置数据源用户
     *
     * @param dataSourceUser 数据源用户
     */
    public void setDataSourceUser(String dataSourceUser) {
        this.dataSourceUser = dataSourceUser;
    }

    /**
     * 获取数据源密码
     *
     * @return data_source_pwd - 数据源密码
     */
    public String getDataSourcePwd() {
        return dataSourcePwd;
    }

    /**
     * 设置数据源密码
     *
     * @param dataSourcePwd 数据源密码
     */
    public void setDataSourcePwd(String dataSourcePwd) {
        this.dataSourcePwd = dataSourcePwd;
    }

    /**
     * 获取Jdbc驱动包名
     *
     * @return jdbc_driver_type - Jdbc驱动包名
     */
    public String getJdbcDriverType() {
        return jdbcDriverType;
    }

    /**
     * 设置Jdbc驱动包名
     *
     * @param jdbcDriverType Jdbc驱动包名
     */
    public void setJdbcDriverType(String jdbcDriverType) {
        this.jdbcDriverType = jdbcDriverType;
    }

    /**
     * 获取租户标识
     *
     * @return tenant_id - 租户标识
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * 设置租户标识
     *
     * @param tenantId 租户标识
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * 获取租户类型（0-database，1-schema，2-discriminator）
     *
     * @return tenant_type - 租户类型（0-database，1-schema，2-discriminator）
     */
    public String getTenantType() {
        return tenantType;
    }

    /**
     * 设置租户类型（0-database，1-schema，2-discriminator）
     *
     * @param tenantType 租户类型（0-database，1-schema，2-discriminator）
     */
    public void setTenantType(String tenantType) {
        this.tenantType = tenantType;
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
        sb.append(", dataSourceCode=").append(dataSourceCode);
        sb.append(", dataSourceUrl=").append(dataSourceUrl);
        sb.append(", dataSourceUser=").append(dataSourceUser);
        sb.append(", dataSourcePwd=").append(dataSourcePwd);
        sb.append(", jdbcDriverType=").append(jdbcDriverType);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", tenantType=").append(tenantType);
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