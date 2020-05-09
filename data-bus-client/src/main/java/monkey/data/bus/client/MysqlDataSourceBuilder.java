package monkey.data.bus.client;

import com.alibaba.druid.pool.DruidDataSource;
import monkey.config.bus.data.model.ScDbNode;

import javax.sql.DataSource;

public class MysqlDataSourceBuilder implements DbDataSourceBuilder {

    public DataSource build(ScDbNode node) {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(node.getUrl());
        datasource.setUsername(node.getUserName());
        datasource.setPassword(node.getPassword());
        datasource.setInitialSize(8);
        datasource.setMinIdle(16);
        datasource.setMaxActive(32);
        datasource.setMaxWait(30000);

        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setValidationQuery("SELECT 1 FROM DUAL");
        datasource.setTestWhileIdle(true);
        datasource.setTestOnBorrow(false);
        datasource.setTestOnReturn(false);
        datasource.setMinEvictableIdleTimeMillis(1800000);
        datasource.setTimeBetweenEvictionRunsMillis(60000);
        datasource.setPoolPreparedStatements(true);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(20);

        return datasource;
    }
}
