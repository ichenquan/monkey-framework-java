package monkey.data.bus.client;

import monkey.config.bus.data.model.ScDbNode;

import javax.sql.DataSource;

public interface DbDataSourceBuilder {

    DataSource build(ScDbNode node);
}
