package monkey.config.bus.server.controller;

import monkey.common.Result;
import monkey.config.bus.data.model.ScApplicationProperty;
import monkey.config.bus.server.service.contract.ScApplicationPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ChenQ
 * @date 2020/4/28
 */
@RestController
public class ScApplicationPropertyController {

    @Autowired
    private ScApplicationPropertyService scApplicationPropertyService;

    @RequestMapping("/sc/application/property/get")
    public Result<ScApplicationProperty> get(String applicationId, String propertyId) {
        return scApplicationPropertyService.get(applicationId, propertyId);
    }

    @RequestMapping("/sc/application/property/find")
    public Result<List<ScApplicationProperty>> find(String applicationId) {
        return scApplicationPropertyService.find(applicationId);
    }
}
