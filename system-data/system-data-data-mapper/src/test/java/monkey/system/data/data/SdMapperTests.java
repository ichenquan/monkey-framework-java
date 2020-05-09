package monkey.system.data.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.config.MysqldConfig;
import monkey.system.data.data.mapper.*;
import monkey.system.data.data.model.*;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;
import static com.wix.mysql.ScriptResolver.classPathScript;
import static com.wix.mysql.config.Charset.UTF8;
import static com.wix.mysql.config.MysqldConfig.aMysqldConfig;
import static com.wix.mysql.distribution.Version.v5_7_latest;
import static org.junit.Assert.assertEquals;

public class SdMapperTests {
    private EmbeddedMysql mysqld;

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void mysqldConfigAndMultipleSchemas() {
        MysqldConfig config = aMysqldConfig(v5_7_latest)
                .withCharset(UTF8)
                .withPort(2215)
                .withUser("user", "password")
                .build();

        mysqld = anEmbeddedMysql(config)
                .addSchema("schema1", classPathScript("db.sql"))
                .start();

        //init druid
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:2215/schema1");
        dataSource.setUsername("user");
        dataSource.setPassword("password");

        //init mybatis
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Configuration configuration = new Configuration(new Environment("development", transactionFactory, dataSource));
        configuration.getTypeAliasRegistry().registerAlias(SdDictType.class);
        configuration.addMapper(SdDictTypeMapper.class);
        configuration.getTypeAliasRegistry().registerAlias(SdDictData.class);
        configuration.addMapper(SdDictDataMapper.class);
        configuration.getTypeAliasRegistry().registerAlias(SdDataSource.class);
        configuration.addMapper(SdDataSourceMapper.class);
        configuration.getTypeAliasRegistry().registerAlias(SdDesignerTable.class);
        configuration.getTypeAliasRegistry().registerAlias(SdDesignerColumn.class);
        configuration.addMapper(SdDesignerTableMapper.class);
        configuration.addMapper(SdDesignerColumnMapper.class);

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    @After
    public void cleanup() {
        mysqld.stop(); //optional, as there is a shutdown hook
    }

    @Test
    public void ensureMysqlIsWorking() throws SQLException {
        String url = "jdbc:mysql://localhost:2215/schema1";
        final Connection conn = DriverManager.getConnection(url, "user", "password");
        final Statement statement = conn.createStatement();
        assertEquals(true, statement.execute("SELECT * FROM sd_dict_type;"));
        final ResultSet resultSet = statement.getResultSet();
        assertEquals(true, resultSet.next());
        assertEquals(0, resultSet.getInt("flag"));
        assertEquals("sys_user_sex", resultSet.getString("dict_type"));
    }

//    @Test
//    public void ensureSdDictTypeSupportCRUD() {
//        SqlSession session = sqlSessionFactory.openSession();
//        SdDictTypeMapper mapper = session.getMapper(SdDictTypeMapper.class);
//
//        SdDictType dictType = new SdDictType();
//        dictType.setDictName("test dict");
//        dictType.setDictType("test-dict");
//        dictType.setOwnedDeptId(200L);
//        dictType.setCreateUserId(1L);
//        dictType.setStatus("0");
//
//        int result = mapper.insert(dictType);
//        assertEquals(1, result);
//    }
}
