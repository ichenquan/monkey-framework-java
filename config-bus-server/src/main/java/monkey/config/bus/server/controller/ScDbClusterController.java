package monkey.config.bus.server.controller;

import monkey.common.Result;
import monkey.config.bus.data.model.ScDbCluster;
import monkey.config.bus.server.service.contract.ScDbClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ChenQ
 * @date 2020/4/28
 */
@RestController
public class ScDbClusterController {

    @Autowired
    private ScDbClusterService scMysqlClusterService;

    @RequestMapping("/sc/db/cluster/get/all")
    public Result<List<ScDbCluster>> getAll() {
        return scMysqlClusterService.getAll();
    }
}
