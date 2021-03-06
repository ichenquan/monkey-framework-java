package water.framework.system.schema.data.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import monkey.common.DbPageParameter;

@Table(name = "ss_menu")
public class SsMenu extends DbPageParameter implements Serializable {
    /**
     * 菜单ID
     */
    @Id
    private Long id;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 父菜单ID
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 显示顺序
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 是否为外链（0是 1否）
     */
    @Column(name = "is_frame")
    private Integer isFrame;

    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    @Column(name = "menu_type")
    private String menuType;

    /**
     * 菜单状态（0显示 1隐藏）
     */
    private String visible;

    /**
     * 菜单状态（0正常 1停用）
     */
    private String status;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 菜单图标
     */
    private String icon;

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
     * 获取菜单ID
     *
     * @return id - 菜单ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置菜单ID
     *
     * @param id 菜单ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取菜单名称
     *
     * @return menu_name - 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名称
     *
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 获取父菜单ID
     *
     * @return parent_id - 父菜单ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父菜单ID
     *
     * @param parentId 父菜单ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
     * 获取路由地址
     *
     * @return path - 路由地址
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置路由地址
     *
     * @param path 路由地址
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取组件路径
     *
     * @return component - 组件路径
     */
    public String getComponent() {
        return component;
    }

    /**
     * 设置组件路径
     *
     * @param component 组件路径
     */
    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * 获取是否为外链（0是 1否）
     *
     * @return is_frame - 是否为外链（0是 1否）
     */
    public Integer getIsFrame() {
        return isFrame;
    }

    /**
     * 设置是否为外链（0是 1否）
     *
     * @param isFrame 是否为外链（0是 1否）
     */
    public void setIsFrame(Integer isFrame) {
        this.isFrame = isFrame;
    }

    /**
     * 获取菜单类型（M目录 C菜单 F按钮）
     *
     * @return menu_type - 菜单类型（M目录 C菜单 F按钮）
     */
    public String getMenuType() {
        return menuType;
    }

    /**
     * 设置菜单类型（M目录 C菜单 F按钮）
     *
     * @param menuType 菜单类型（M目录 C菜单 F按钮）
     */
    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    /**
     * 获取菜单状态（0显示 1隐藏）
     *
     * @return visible - 菜单状态（0显示 1隐藏）
     */
    public String getVisible() {
        return visible;
    }

    /**
     * 设置菜单状态（0显示 1隐藏）
     *
     * @param visible 菜单状态（0显示 1隐藏）
     */
    public void setVisible(String visible) {
        this.visible = visible;
    }

    /**
     * 获取菜单状态（0正常 1停用）
     *
     * @return status - 菜单状态（0正常 1停用）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置菜单状态（0正常 1停用）
     *
     * @param status 菜单状态（0正常 1停用）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取权限标识
     *
     * @return perms - 权限标识
     */
    public String getPerms() {
        return perms;
    }

    /**
     * 设置权限标识
     *
     * @param perms 权限标识
     */
    public void setPerms(String perms) {
        this.perms = perms;
    }

    /**
     * 获取菜单图标
     *
     * @return icon - 菜单图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置菜单图标
     *
     * @param icon 菜单图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
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
        sb.append(", menuName=").append(menuName);
        sb.append(", parentId=").append(parentId);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", path=").append(path);
        sb.append(", component=").append(component);
        sb.append(", isFrame=").append(isFrame);
        sb.append(", menuType=").append(menuType);
        sb.append(", visible=").append(visible);
        sb.append(", status=").append(status);
        sb.append(", perms=").append(perms);
        sb.append(", icon=").append(icon);
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