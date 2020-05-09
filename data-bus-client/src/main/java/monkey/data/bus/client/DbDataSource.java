package monkey.data.bus.client;

import monkey.config.bus.data.model.ScDbNode;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class DbDataSource extends AbstractRoutingDataSource {

    @Override
    public void afterPropertiesSet() {
        Map<Object, Object> dataSources = new HashMap<>();
        DbSourceTemporary temporary = new DbSourceTemporary();
        setDefaultTargetDataSource(temporary);
        dataSources.put("temporary", temporary);
        setTargetDataSources(dataSources);

        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DbDataSourceScheduler.selectedNodeId();
    }

    public void initialize() {
        Map<Object, Object> dataSources = new HashMap<>();
        DbDataSourceBuilder builder = createBuilder(DbCluster.getMasterNode());
        DataSource master = builder.build(DbCluster.getMasterNode());
        dataSources.put(DbCluster.getMasterNode().getNodeId(), master);

        setDefaultTargetDataSource(master);

        for (ScDbNode node : DbCluster.getSlaveNodes()) {
            DataSource slave = builder.build(node);
            dataSources.put(node.getNodeId(), slave);
        }

        setTargetDataSources(dataSources);

        super.afterPropertiesSet();
    }

    private DbDataSourceBuilder createBuilder(ScDbNode node) {
        return new MysqlDataSourceBuilder();
    }
}
