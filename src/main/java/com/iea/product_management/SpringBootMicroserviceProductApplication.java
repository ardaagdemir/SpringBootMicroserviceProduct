package com.iea.product_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application-${spring.profiles.active:production}.properties")
public class SpringBootMicroserviceProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMicroserviceProductApplication.class, args);
    }

}
