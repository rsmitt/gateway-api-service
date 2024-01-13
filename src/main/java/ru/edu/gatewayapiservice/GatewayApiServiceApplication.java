package ru.edu.gatewayapiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GatewayApiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApiServiceApplication.class, args);
    }

}
