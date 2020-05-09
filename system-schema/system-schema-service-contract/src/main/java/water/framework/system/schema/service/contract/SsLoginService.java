package water.framework.system.schema.service.contract;

import water.framework.system.schema.data.model.SsUser;

public interface SsLoginService {
    /**
     * 登录验证
     *
     * @param username 用户名
     * @param password 密码
     * @param code 验证码
     * @param uuid 唯一标识
     * @return 结果
     */
    String login(String username, String password, String code, String uuid);

    /**
     * 注册账号
     *
     * @param username 用户名
     * @param password 密码
     * @param confirmPassword 确认密码
     * @param code 验证码
     * @param uuid 验证码标识
     * @return 结果
     */
    SsUser register(String username, String password, String confirmPassword, String code, String uuid);
}
