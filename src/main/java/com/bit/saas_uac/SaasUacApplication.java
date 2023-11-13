package com.bit.saas_uac;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bit.saas_uac.mapper")
public class SaasUacApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaasUacApplication.class, args);
    }

}
