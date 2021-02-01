package tech.qijin.study.transaction.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
public class AtomikosTransactionConfig {

    @Bean
    @Primary
    public JtaTransactionManager dataSourceTransactionManager() {
        JtaTransactionManager transactionManager = new JtaTransactionManager();
        transactionManager.setTransactionManager(new UserTransactionManager());
        transactionManager.setUserTransaction(new UserTransactionImp());
        return transactionManager;
    }
}
