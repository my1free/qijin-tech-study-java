package tech.qijin.study.transaction.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.datasource.db2")
public class DB2Properties {
    private String jdbcUrl;
    private String username;
    private String password;
    private String driverClassName;
}
