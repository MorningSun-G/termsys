package com.jxd.termsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.jxd.termsys.dao")
public class TermsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(TermsysApplication.class, args);
    }

}
