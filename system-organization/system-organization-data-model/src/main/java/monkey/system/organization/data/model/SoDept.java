package monkey.system.organization.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import monkey.common.DbPageParameter;

@Table(name = "so_dept")
public class SoDept extends DbPageParameter implements Serializable {
    /**
     * 部门id
     */
    @Id
    private Long id;

    /**
     * 父部门id
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 祖级列表
     */
    private String ancestors;

    /**
     * 部门名称
     */
    @Column(name = "dept_name")
    private String deptName;

    /**
     * 显示顺序
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 负责人
     */
    private String leader;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 部门状态（0正常 1停用）
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
    /** 子部门 */
    private List<SoDept> children = new ArrayList<SoDept>();

    private static final long serialVersionUID = 1L;

    /**
     * 获取部门id
     *
     * @return id - 部门id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置部门id
     *
     * @param id 部门id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取父部门id
     *
     * @return parent_id - 父部门id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父部门id
     *
     * @param parentId 父部门id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取祖级列表
     *
     * @return ancestors - 祖级列表
     */
    public String getAncestors() {
        return ancestors;
    }

    /**
     * 设置祖级列表
     *
     * @param ancestors 祖级列表
     */
    public void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }

    /**
     * 获取部门名称
     *
     * @return dept_name - 部门名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置部门名称
     *
     * @param deptName 部门名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取显示顺序
     *
     * @return order_num - 显示顺序
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 设置显示顺序
     *
     * @param orderNum 显示顺序
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取负责人
     *
     * @return leader - 负责人
     */
    public String getLeader() {
        return leader;
    }

    /**
     * 设置负责人
     *
     * @param leader 负责人
     */
    public void setLeader(String leader) {
        this.leader = leader;
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取部门状态（0正常 1停用）
     *
     * @return status - 部门状态（0正常 1停用）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置部门状态（0正常 1停用）
     *
     * @param status 部门状态（0正常 1停用）
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", ancestors=").append(ancestors);
        sb.append(", deptName=").append(deptName);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", leader=").append(leader);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", status=").append(status);
        sb.append(", flag=").append(flag);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public List<SoDept> getChildren() {
        return children;
    }

    public void setChildren(List<SoDept> children) {
        this.children = children;
    }
}