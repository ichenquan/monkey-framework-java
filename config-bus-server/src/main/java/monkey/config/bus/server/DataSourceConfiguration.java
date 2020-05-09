package monkey.config.bus.server;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@ComponentScan(basePackages = {"monkey"})
@MapperScan(basePackages = {"monkey.config.bus.server.data.mapper"}, sqlSessionFactoryRef = "configBusSqlSessionFactory")
public class DataSourceConfiguration {

    @Autowired
    private DatabaseConfiguration databaseConfiguration;

    @Bean(name = "configBusDataSource")
    public DruidDataSource configBusDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(databaseConfiguration.getUrl());
        dataSource.setUsername(databaseConfiguration.getUser());
        dataSource.setPassword(databaseConfiguration.getPassword());
        return dataSource;
    }

    @Bean(name = "configBusSqlSessionFactory")
    public SqlSessionFactory configBusSqlSessionFactory(@Qualifier("configBusDataSource") DruidDataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
    }

    @Bean(name = "configBusSessionTemplate")
    public SqlSessionTemplate configBusSessionTemplate(@Qualifier("configBusSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
