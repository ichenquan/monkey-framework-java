package water.framework.system.schema.data.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import monkey.common.DbPageParameter;

@Table(name = "ss_role")
public class SsRole extends DbPageParameter implements Serializable {
    /**
     * 角色ID
     */
    @Id
    private Long id;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色权限字符串
     */
    @Column(name = "role_key")
    private String roleKey;

    /**
     * 显示顺序
     */
    @Column(name = "role_sort")
    private Integer roleSort;

    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    @Column(name = "data_scope")
    private String dataScope;

    /**
     * 角色状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String flag;

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
     * 获取角色ID
     *
     * @return id - 角色ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置角色ID
     *
     * @param id 角色ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取角色权限字符串
     *
     * @return role_key - 角色权限字符串
     */
    public String getRoleKey() {
        return roleKey;
    }

    /**
     * 设置角色权限字符串
     *
     * @param roleKey 角色权限字符串
     */
    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    /**
     * 获取显示顺序
     *
     * @return role_sort - 显示顺序
     */
    public Integer getRoleSort() {
        return roleSort;
    }

    /**
     * 设置显示顺序
     *
     * @param roleSort 显示顺序
     */
    public void setRoleSort(Integer roleSort) {
        this.roleSort = roleSort;
    }

    /**
     * 获取数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     *
     * @return data_scope - 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    public String getDataScope() {
        return dataScope;
    }

    /**
     * 设置数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     *
     * @param dataScope 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }

    /**
     * 获取角色状态（0正常 1停用）
     *
     * @return status - 角色状态（0正常 1停用）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置角色状态（0正常 1停用）
     *
     * @param status 角色状态（0正常 1停用）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取删除标志（0代表存在 2代表删除）
     *
     * @return flag - 删除标志（0代表存在 2代表删除）
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 设置删除标志（0代表存在 2代表删除）
     *
     * @param flag 删除标志（0代表存在 2代表删除）
     */
    public void setFlag(String flag) {
        this.flag = flag;
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
        sb.append(", roleName=").append(roleName);
        sb.append(", roleKey=").append(roleKey);
        sb.append(", roleSort=").append(roleSort);
        sb.append(", dataScope=").append(dataScope);
        sb.append(", status=").append(status);
        sb.append(", flag=").append(flag);
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