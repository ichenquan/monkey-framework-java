package monkey.data.bus.client;

import monkey.common.ObjectContainer;
import monkey.common.Result;
import monkey.config.bus.client.ConfigBus;
import monkey.config.bus.data.model.ScDbNode;
import monkey.config.bus.data.model.ScDbParameter;
import monkey.config.bus.data.model.ScDbPath;
import monkey.config.bus.client.service.ScDbNodeService;
import monkey.config.bus.client.service.ScDbPathService;

import java.util.List;

public class DataBus {

    private static boolean isFirstStart = true;
    private static DbDataSource dataSource;
    private static List<ScDbNode> nodes;

    public static synchronized void start() {
        if (isFirstStart) {
            isFirstStart = false;
            ConfigBus.start();

            loadDataNodes();
            initializeDataSource();
        }
    }

    public static synchronized void update(ScDbParameter parameter) {
        if (parameter.getApplicationId().equals(ConfigBus.getApplicationId())) {
            nodes = parameter.getNodes();
            initializeDataSource();
        }
    }

    private static void loadDataNodes() {
        if (nodes == null) {
            String applicationId = ConfigBus.getApplicationId();
            Result<ScDbPath> dbPathResult = ObjectContainer.getObject(ScDbPathService.class).get(applicationId);
            if (dbPathResult.isSuccess()) {
                ScDbPath path = dbPathResult.getData();
                if (path == null) {
                    ConfigBus.exit("未配置数据库路由");
                }
                Result<List<ScDbNode>> result = ObjectContainer.getObject(ScDbNodeService.class).get(path.getClusterId());
                if (result.isSuccess()) {
                    nodes = result.getData();
                }
            }
        }
    }

    private static void initializeDataSource() {
        DbCluster.add(nodes);
        dataSource = ObjectContainer.getObject(DbDataSource.class);
        dataSource.initialize();
    }
}
