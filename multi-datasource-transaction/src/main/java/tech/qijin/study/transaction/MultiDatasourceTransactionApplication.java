package tech.qijin.study.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="tech.qijin.study.transaction")
public class MultiDatasourceTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiDatasourceTransactionApplication.class, args);
	}

}
