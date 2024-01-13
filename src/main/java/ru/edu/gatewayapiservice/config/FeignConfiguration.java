package ru.edu.gatewayapiservice.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
    // нужно для http basic соединения с другими микросерсисами.
    // Нам надо послать авторизационный header в другие сервисы
    // в Main @EnableFeignClients

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(
            @Value("${service.security.secure-key-username}") String username,
            @Value("${service.security.secure-key-password}") String password)
    {
        return new BasicAuthRequestInterceptor(username, password);
    }
}
