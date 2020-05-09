package water.framework.system.schema.service.contract;

import water.framework.system.schema.data.model.SsUser;

import java.util.Set;

public interface SsPermissionService {
    /**
     * 获取角色数据权限
     *
     * @param user 用户信息
     * @return 角色权限信息
     */
    Set<String> getRolePermission(SsUser user);

    /**
     * 获取菜单数据权限
     *
     * @param user 用户信息
     * @return 菜单权限信息
     */
    Set<String> getMenuPermission(SsUser user);
}
