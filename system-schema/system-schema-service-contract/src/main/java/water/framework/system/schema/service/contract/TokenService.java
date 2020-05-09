package water.framework.system.schema.service.contract;

import water.framework.system.schema.service.contract.vo.LoginUser;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {
    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    LoginUser getLoginUser(HttpServletRequest request);

    /**
     * 设置用户身份信息
     */
    void setLoginUser(LoginUser loginUser);

    /**
     * 删除用户身份信息
     */
    void delLoginUser(String token);

    /**
     * 创建令牌
     *
     * @param loginUser 用户信息
     * @return 令牌
     */
    String createToken(LoginUser loginUser);

    /**
     * 验证令牌有效期，相差不足20分钟，自动刷新缓存
     *
     * @param loginUser 令牌
     * @return 令牌
     */
    void verifyToken(LoginUser loginUser);

    /**
     * 刷新令牌有效期
     *
     * @param loginUser 登录信息
     */
    void refreshToken(LoginUser loginUser);

    /**
     * 设置用户代理信息
     *
     * @param loginUser 登录信息
     */
    void setUserAgent(LoginUser loginUser);

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    String getUsernameFromToken(String token);
}
