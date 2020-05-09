package monkey.config.bus.server.controller;

import monkey.config.bus.server.DatabaseConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * FileName: SystemConfigController
 * Description:
 * Author: ChenQ
 * Date: 2020/4/28
 */
@RestController
public class SystemConfigController {

    @Autowired
    private DatabaseConfiguration databaseConfiguration;

    @RequestMapping("/db/sc/get")
    public Map<String, String> getDBForSc() {
        Map<String, String> dbInfo = new HashMap<>(3);
        dbInfo.put("url", databaseConfiguration.getUrl());
        dbInfo.put("user", databaseConfiguration.getUser());
        dbInfo.put("password", databaseConfiguration.getPassword());
        return dbInfo;
    }
}
