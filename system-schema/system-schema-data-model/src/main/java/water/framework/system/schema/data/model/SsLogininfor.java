package water.framework.system.schema.data.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import monkey.common.DbPageParameter;

@Table(name = "ss_logininfor")
public class SsLogininfor extends DbPageParameter implements Serializable {
    /**
     * 访问ID
     */
    @Id
    private Long id;

    /**
     * 用户账号
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 登录地点
     */
    @Column(name = "login_location")
    private String loginLocation;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 登录状态（0成功 1失败）
     */
    private String status;

    /**
     * 提示消息
     */
    private String msg;

    /**
     * 访问时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取访问ID
     *
     * @return id - 访问ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置访问ID
     *
     * @param id 访问ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户账号
     *
     * @return user_name - 用户账号
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户账号
     *
     * @param userName 用户账号
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取登录IP地址
     *
     * @return ipaddr - 登录IP地址
     */
    public String getIpaddr() {
        return ipaddr;
    }

    /**
     * 设置登录IP地址
     *
     * @param ipaddr 登录IP地址
     */
    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    /**
     * 获取登录地点
     *
     * @return login_location - 登录地点
     */
    public String getLoginLocation() {
        return loginLocation;
    }

    /**
     * 设置登录地点
     *
     * @param loginLocation 登录地点
     */
    public void setLoginLocation(String loginLocation) {
        this.loginLocation = loginLocation;
    }

    /**
     * 获取浏览器类型
     *
     * @return browser - 浏览器类型
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * 设置浏览器类型
     *
     * @param browser 浏览器类型
     */
    public void setBrowser(String browser) {
        this.browser = browser;
    }

    /**
     * 获取操作系统
     *
     * @return os - 操作系统
     */
    public String getOs() {
        return os;
    }

    /**
     * 设置操作系统
     *
     * @param os 操作系统
     */
    public void setOs(String os) {
        this.os = os;
    }

    /**
     * 获取登录状态（0成功 1失败）
     *
     * @return status - 登录状态（0成功 1失败）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置登录状态（0成功 1失败）
     *
     * @param status 登录状态（0成功 1失败）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取提示消息
     *
     * @return msg - 提示消息
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置提示消息
     *
     * @param msg 提示消息
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取访问时间
     *
     * @return login_time - 访问时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置访问时间
     *
     * @param loginTime 访问时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", ipaddr=").append(ipaddr);
        sb.append(", loginLocation=").append(loginLocation);
        sb.append(", browser=").append(browser);
        sb.append(", os=").append(os);
        sb.append(", status=").append(status);
        sb.append(", msg=").append(msg);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}