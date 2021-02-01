package tech.qijin.study.transaction.config;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableConfigurationProperties(DB2Properties.class)
@MapperScan(basePackages = "tech.qijin.study.transaction.mysql.db2.dao", sqlSessionTemplateRef = "db2SqlSessionTemplate")
public class DB2Configuration {
    @Autowired
    private DB2Properties db2Properties;

    @Bean("db2Datasource")
    public DataSource dataSource() throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(db2Properties.getJdbcUrl());
        mysqlXaDataSource.setPassword(db2Properties.getPassword());
        mysqlXaDataSource.setUser(db2Properties.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setXaDataSource(mysqlXaDataSource);
        ds.setMaxPoolSize(20);
        ds.setPoolSize(5);
        ds.setUniqueResourceName("xadb2");
        return ds;
    }

    @Bean("db2SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("db2Datasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfigLocation(new ClassPathResource("sqlMapConfig.xml"));
        return bean.getObject();
    }

    @Bean(name = "db2SqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("db2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
//
//    @Bean(name = "db2TransactionManager")
//    public DataSourceTransactionManager setTransactionManager(@Qualifier("db2Datasource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
}
