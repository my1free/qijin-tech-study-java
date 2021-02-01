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
@MapperScan(basePackages = "tech.qijin.study.transaction.mysql.db1.dao", sqlSessionTemplateRef = "db1SqlSessionTemplate")
@EnableConfigurationProperties(DB1Properties.class)
public class DB1Configuration {
    @Autowired
    private DB1Properties db1Properties;

    @Primary
    @Bean("db1Datasource")
    public DataSource dataSource() throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(db1Properties.getJdbcUrl());
        mysqlXaDataSource.setPassword(db1Properties.getPassword());
        mysqlXaDataSource.setUser(db1Properties.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setXaDataSource(mysqlXaDataSource);
        ds.setMaxPoolSize(20);
        ds.setPoolSize(5);
//        ds.setTestQuery("select 1");
        ds.setUniqueResourceName("xadb1");
        return ds;
    }

    @Primary
    @Bean("db1SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("db1Datasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfigLocation(new ClassPathResource("sqlMapConfig.xml"));
        return bean.getObject();
    }

    @Primary
    @Bean(name = "db1SqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

//    @Primary
//    @Bean(name = "db1TransactionManager")
//    public DataSourceTransactionManager setTransactionManager(@Qualifier("db1Datasource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
}
