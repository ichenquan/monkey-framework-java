package monkey.config.bus.server.controller;

import monkey.common.Result;
import monkey.config.bus.data.model.ScApplication;
import monkey.config.bus.server.service.contract.ScApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ChenQ
 * @date 2020/4/28
 */
@RestController
public class ScApplicationController {

    @Autowired
    private ScApplicationService scApplicationService;

    @RequestMapping("/sc/application/get/all")
    public Result<List<ScApplication>> getAll() {
        return scApplicationService.getAll();
    }
}
