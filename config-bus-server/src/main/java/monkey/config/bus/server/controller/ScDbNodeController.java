package monkey.config.bus.server.controller;

import monkey.common.Result;
import monkey.config.bus.data.model.ScDbNode;
import monkey.config.bus.server.service.contract.ScDbNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ChenQ
 * @date 2020/4/28
 */
@RestController
public class ScDbNodeController {

    @Autowired
    private ScDbNodeService scMysqlNodeService;

    @RequestMapping("/sc/db/node/get")
    public Result<List<ScDbNode>> get(String clusterId) {
        return scMysqlNodeService.get(clusterId);
    }
}
