package tech.qijin.study.metrics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Slf4j
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class StudyMetricsApplication {

    public static void main(String[] args) throws ParseException {
        SpringApplication.run(StudyMetricsApplication.class, args);
    }

}
