package monkey.config.bus.server.controller;

import monkey.common.Result;
import monkey.config.bus.data.model.ScServicePath;
import monkey.config.bus.server.service.contract.ScServicePathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ChenQ
 * @date 2020/4/28
 */
@RestController
public class ScServicePathController {

    @Autowired
    private ScServicePathService scServicePathService;

    @RequestMapping("/sc/service/path/get/all")
    public Result<List<ScServicePath>> getAll() {
        return scServicePathService.getAll();
    }

    @RequestMapping("/sc/service/path/register")
    public Result<ScServicePath> register(String serviceHost, String serviceNames) {
        return scServicePathService.register(serviceHost, serviceNames);
    }

    @RequestMapping("/sc/service/path/delete")
    public Result delete(String serviceHost) {
        return scServicePathService.delete(serviceHost);
    }

    @RequestMapping("/sc/service/path/get/one")
    public Result<ScServicePath> findOne(String serviceHost) {
        return scServicePathService.findOne(serviceHost);
    }
}
