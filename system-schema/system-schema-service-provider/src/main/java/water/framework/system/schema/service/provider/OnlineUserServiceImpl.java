package water.framework.system.schema.service.provider;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import water.framework.system.schema.service.contract.OnlineUserService;
import water.framework.system.schema.service.contract.vo.LoginUser;
import water.framework.system.schema.service.contract.vo.OnlineUser;

/**
 * 在线用户 服务层处理
 * 
 * @author lijing
 */
@Service
public class OnlineUserServiceImpl implements OnlineUserService
{
    /**
     * 通过登录地址查询信息
     * 
     * @param ipaddr 登录地址
     * @param user 用户信息
     * @return 在线用户信息
     */
    @Override
    public OnlineUser selectOnlineByIpaddr(String ipaddr, LoginUser user)
    {
        if (StringUtils.equals(ipaddr, user.getIpaddr()))
        {
            return loginUserToUserOnline(user);
        }
        return null;
    }

    /**
     * 通过用户名称查询信息
     * 
     * @param userName 用户名称
     * @param user 用户信息
     * @return 在线用户信息
     */
    @Override
    public OnlineUser selectOnlineByUserName(String userName, LoginUser user)
    {
        if (StringUtils.equals(userName, user.getUsername()))
        {
            return loginUserToUserOnline(user);
        }
        return null;
    }

    /**
     * 通过登录地址/用户名称查询信息
     * 
     * @param ipaddr 登录地址
     * @param userName 用户名称
     * @param user 用户信息
     * @return 在线用户信息
     */
    @Override
    public OnlineUser selectOnlineByInfo(String ipaddr, String userName, LoginUser user)
    {
        if (StringUtils.equals(ipaddr, user.getIpaddr()) && StringUtils.equals(userName, user.getUsername()))
        {
            return loginUserToUserOnline(user);
        }
        return null;
    }

    /**
     * 设置在线用户信息
     * 
     * @param user 用户信息
     * @return 在线用户
     */
    public OnlineUser loginUserToUserOnline(LoginUser user)
    {
        if (user == null)
        {
            return null;
        }
        OnlineUser OnlineUser = new OnlineUser();
        OnlineUser.setTokenId(user.getToken());
        OnlineUser.setUserName(user.getUsername());
        OnlineUser.setIpaddr(user.getIpaddr());
        OnlineUser.setLoginLocation(user.getLoginLocation());
        OnlineUser.setBrowser(user.getBrowser());
        OnlineUser.setOs(user.getOs());
        OnlineUser.setLoginTime(user.getLoginTime());
        if (user.getDept())
        {
            OnlineUser.setDeptName(user.getDept().getDeptName());
        }
        return OnlineUser;
    }
}
