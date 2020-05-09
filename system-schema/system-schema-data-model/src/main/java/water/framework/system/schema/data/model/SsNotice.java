package water.framework.system.schema.data.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import monkey.common.DbPageParameter;

@Table(name = "ss_notice")
public class SsNotice extends DbPageParameter implements Serializable {
    /**
     * 公告ID
     */
    @Id
    private Integer id;

    /**
     * 公告标题
     */
    @Column(name = "notice_title")
    private String noticeTitle;

    /**
     * 公告类型（1通知 2公告）
     */
    @Column(name = "notice_type")
    private String noticeType;

    /**
     * 公告内容
     */
    @Column(name = "notice_content")
    private String noticeContent;

    /**
     * 公告状态（0正常 1关闭）
     */
    private String status;

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
     * 获取公告ID
     *
     * @return id - 公告ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置公告ID
     *
     * @param id 公告ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取公告标题
     *
     * @return notice_title - 公告标题
     */
    public String getNoticeTitle() {
        return noticeTitle;
    }

    /**
     * 设置公告标题
     *
     * @param noticeTitle 公告标题
     */
    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    /**
     * 获取公告类型（1通知 2公告）
     *
     * @return notice_type - 公告类型（1通知 2公告）
     */
    public String getNoticeType() {
        return noticeType;
    }

    /**
     * 设置公告类型（1通知 2公告）
     *
     * @param noticeType 公告类型（1通知 2公告）
     */
    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    /**
     * 获取公告内容
     *
     * @return notice_content - 公告内容
     */
    public String getNoticeContent() {
        return noticeContent;
    }

    /**
     * 设置公告内容
     *
     * @param noticeContent 公告内容
     */
    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    /**
     * 获取公告状态（0正常 1关闭）
     *
     * @return status - 公告状态（0正常 1关闭）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置公告状态（0正常 1关闭）
     *
     * @param status 公告状态（0正常 1关闭）
     */
    public void setStatus(String status) {
        this.status = status;
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
        sb.append(", noticeTitle=").append(noticeTitle);
        sb.append(", noticeType=").append(noticeType);
        sb.append(", noticeContent=").append(noticeContent);
        sb.append(", status=").append(status);
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