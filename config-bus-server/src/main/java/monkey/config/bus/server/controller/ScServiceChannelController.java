package monkey.config.bus.server.controller;

import monkey.common.Result;
import monkey.config.bus.data.model.ScServiceChannel;
import monkey.config.bus.server.service.contract.ScServiceChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ChenQ
 * @date 2020/4/28
 */
@RestController
public class ScServiceChannelController {

    @Autowired
    private ScServiceChannelService scServiceChannelService;

    @RequestMapping("/sc/service/channel/get/all")
    public Result<List<ScServiceChannel>> getAll() {
        return scServiceChannelService.getAll();
    }
}