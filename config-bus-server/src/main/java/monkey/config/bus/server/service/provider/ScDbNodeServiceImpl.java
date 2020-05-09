package monkey.config.bus.server.service.provider;

import monkey.common.DbServiceImpl;
import monkey.common.Result;
import monkey.common.StringHelper;
import monkey.config.bus.data.model.ScDbNode;
import monkey.config.bus.server.service.contract.ScDbNodeService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.List;

@Service
public class ScDbNodeServiceImpl extends DbServiceImpl<ScDbNode> implements ScDbNodeService {
    private String serviceCode = "sc_dbNode";

    @Override
    public Result<List<ScDbNode>> get(String clusterId) {
        ScDbNode query = new ScDbNode();
        query.setClusterId(clusterId);
        return super.select(query);
    }

    @Override
    public Result<ScDbNode> insert(ScDbNode scMysqlNode) {
        String methodCode = "insert";
        if (scMysqlNode == null)
            return new Result<>(serviceCode, methodCode, 501);
        if (StringUtils.isBlank(scMysqlNode.getClusterId()))
            return new Result<>(serviceCode, methodCode, 502);
        if (StringUtils.isBlank(scMysqlNode.getNodeId()))
            return new Result<>(serviceCode, methodCode, 503);
        if (StringUtils.isBlank(scMysqlNode.getTypeId()))
            return new Result<>(serviceCode, methodCode, 504);
        if (StringUtils.isBlank(scMysqlNode.getUrl()))
            return new Result<>(serviceCode, methodCode, 505);
        if (StringUtils.isBlank(scMysqlNode.getUserName()))
            return new Result<>(serviceCode, methodCode, 506);
        if (StringUtils.isBlank(scMysqlNode.getPassword()))
            return new Result<>(serviceCode, methodCode, 507);
        return super.insert(scMysqlNode);
    }

    @Override
    public Result delete(ScDbNode scMysqlNode) {
        String methodCode = "delete";
        if (scMysqlNode == null)
            return new Result<>(serviceCode, methodCode, 501);
        return super.delete(scMysqlNode);
    }

    @Override
    public Result update(ScDbNode scMysqlNode) {
        String methodCode = "update";
        if (scMysqlNode == null)
            return new Result<>(serviceCode, methodCode, 501);
        return super.update(scMysqlNode);
    }

    @Override
    public Result<ScDbNode> findById(Long id) {
        String methodCode = "findById";
        if (id == null)
            return new Result<>(serviceCode, methodCode, 501);
        return super.selectByPrimaryKey(id);
    }

    @Override
    public Result<PageInfo<ScDbNode>> findByPage(ScDbNode scMysqlNode, Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageNum <= 0)
            pageNum = 1;
        if (pageSize == null || pageSize <= 0)
            pageSize = 10;
        Weekend<ScDbNode> weekend = Weekend.of(ScDbNode.class);
        WeekendCriteria<ScDbNode, Object> criteria = weekend.weekendCriteria();
        if (StringHelper.isNotEmpty(scMysqlNode.getClusterId())) {
            String clusterId = "%" + scMysqlNode.getClusterId() + "%";
            criteria.andLike(ScDbNode::getClusterId, clusterId);
            ///criteria.andEqualTo(ScMysqlNode::getClusterId, scMysqlNode.getClusterId());
        }
        if (StringHelper.isNotEmpty(scMysqlNode.getNodeId())) {
            String nodeId = "%" + scMysqlNode.getNodeId() + "%";
            criteria.andLike(ScDbNode::getNodeId, nodeId);
            //criteria.andEqualTo(ScMysqlNode::getNodeId, scMysqlNode.getNodeId());
        }
        if (StringHelper.isNotEmpty(scMysqlNode.getTypeId())) {
            String typeId = "%" + scMysqlNode.getTypeId() + "%";
            criteria.andLike(ScDbNode::getTypeId, typeId);
            //criteria.andEqualTo(ScMysqlNode::getTypeId, scMysqlNode.getTypeId());
        }
        weekend.orderBy("createTime").desc();
        return super.selectForPage(weekend, pageNum, pageSize);
    }
}
