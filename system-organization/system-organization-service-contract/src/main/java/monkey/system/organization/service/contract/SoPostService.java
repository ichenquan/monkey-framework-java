package monkey.system.organization.service.contract;

import monkey.common.Result;
import monkey.system.organization.data.model.SoPost;

import java.util.List;

/**
 * 岗位信息 服务层
 * 
 * @author ruoyi
 */
public interface SoPostService
{
    /**
     * 查询岗位信息集合
     * 
     * @param post 岗位信息
     * @return 岗位列表
     */
    public Result<List<SoPost>> selectPostList(SoPost post);

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    public Result<List<SoPost>> selectPostAll();

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param postId 岗位ID
     * @return 角色对象信息
     */
    public Result<SoPost> selectPostById(Long postId);

    /**
     * 根据用户ID获取岗位选择框列表
     * 
     * @param userId 用户ID
     * @return 选中岗位ID列表
     */
    public Result<List<Integer>> selectPostListByUserId(Long userId);

    /**
     * 校验岗位名称
     * 
     * @param post 岗位信息
     * @return 结果
     */
    public Result<String> checkPostNameUnique(SoPost post);

    /**
     * 校验岗位编码
     * 
     * @param post 岗位信息
     * @return 结果
     */
    public Result<String> checkPostCodeUnique(SoPost post);

    /**
     * 通过岗位ID查询岗位使用数量
     * 
     * @param postId 岗位ID
     * @return 结果
     */
    public Result<Integer> countUserPostById(Long postId);

    /**
     * 删除岗位信息
     * 
     * @param postId 岗位ID
     * @return 结果
     */
    public Result<Integer> deletePostById(Long postId);

    /**
     * 批量删除岗位信息
     * 
     * @param postIds 需要删除的岗位ID
     * @return 结果
     * @throws Exception 异常
     */
    public Result<Integer> deletePostByIds(Long[] postIds);

    /**
     * 新增保存岗位信息
     * 
     * @param post 岗位信息
     * @return 结果
     */
    public Result<Integer> insertPost(SoPost post);

    /**
     * 修改保存岗位信息
     * 
     * @param post 岗位信息
     * @return 结果
     */
    public Result<Integer> updatePost(SoPost post);

    /**
     * 查询用户所属岗位组
     *
     * @param userName 用户名
     * @return 结果
     */
    public Result<List<SoPost>> selectPostsByUserName(String userName);
}
