package water.framework.system.schema.data.model;

import java.io.Serializable;
import javax.persistence.*;
import monkey.common.DbPageParameter;

@Table(name = "ss_user_post")
public class SsUserPost extends DbPageParameter implements Serializable {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "user_id")
    private Long userId;

    /**
     * 岗位ID
     */
    @Id
    @Column(name = "post_id")
    private Long postId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取岗位ID
     *
     * @return post_id - 岗位ID
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * 设置岗位ID
     *
     * @param postId 岗位ID
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", postId=").append(postId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}