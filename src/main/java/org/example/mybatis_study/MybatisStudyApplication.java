package org.example.mybatis_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class MybatisStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisStudyApplication.class, args);
    }

}
