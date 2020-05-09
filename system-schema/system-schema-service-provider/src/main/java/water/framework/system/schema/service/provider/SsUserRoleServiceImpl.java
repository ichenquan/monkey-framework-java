package water.framework.system.schema.service.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import water.framework.system.schema.data.mapper.SsUserRoleMapper;
import water.framework.system.schema.data.model.SsUserRole;
import water.framework.system.schema.service.contract.SsUserRoleService;

import java.util.List;

@Service
public class SsUserRoleServiceImpl implements SsUserRoleService {
    @Autowired
    private SsUserRoleMapper ssUserRoleMapper;

    @Override
    @Transactional
    public int deleteUserRoleByUserId(Long userId) {
        return ssUserRoleMapper.deleteUserRoleByUserId(userId);
    }

    @Override
    @Transactional
    public int deleteUserRole(Long[] ids) {
        return ssUserRoleMapper.deleteUserRole(ids);
    }

    @Override
    public int countUserRoleByRoleId(Long roleId) {
        return ssUserRoleMapper.countUserRoleByRoleId(roleId);
    }

    @Override
    @Transactional
    public int batchUserRole(List<SsUserRole> userRoleList) {
        return ssUserRoleMapper.batchUserRole(userRoleList);
    }

    @Override
    @Transactional
    public int deleteUserRoleInfo(SsUserRole userRole) {
        return ssUserRoleMapper.deleteUserRoleInfo(userRole);
    }

    @Override
    @Transactional
    public int deleteUserRoleInfos(Long roleId, Long[] userIds) {
        return ssUserRoleMapper.deleteUserRoleInfos(roleId, userIds);
    }
}
