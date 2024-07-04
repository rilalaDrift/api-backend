package com.api.clienttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.api.apiclientsdk")
public class ClientTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientTestApplication.class, args);
    }

}
