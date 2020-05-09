package monkey.data.bus.client;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class DataSourceConfiguration {

    @Bean(name = "dbDataSource")
    public DbDataSource createDataSource() {
        return new DbDataSource();
    }

    @Bean(name = "dbSessionFactory")
    public SqlSessionFactory createSessionFactory(@Qualifier("dbDataSource") DbDataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "dbSessionTemplate")
    public SqlSessionTemplate createSessionTemplate(@Qualifier("dbSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
