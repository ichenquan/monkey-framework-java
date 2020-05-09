package monkey.config.bus.server.controller;

import monkey.common.Result;
import monkey.config.bus.data.model.ScDbPath;
import monkey.config.bus.server.service.contract.ScDbPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChenQ
 * @date 2020/4/28
 */
@RestController
public class ScDbPathController {

    @Autowired
    private ScDbPathService scMysqlPathService;

    @RequestMapping("/sc/db/path/get")
    public Result<ScDbPath> get(String applicationId) {
        return scMysqlPathService.get(applicationId);
    }
}
