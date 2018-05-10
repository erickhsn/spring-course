package com.ericknunes.ericknunes.config;

import com.ericknunes.ericknunes.backend.service.EmailService;
import com.ericknunes.ericknunes.backend.service.MockEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("dev")
@PropertySource("file:///D:/Projetos/Java/ericknunes/spring-course/.ericknunes/application-dev.properties")
public class DevelopmentConfig {

    @Bean
    public EmailService emailService()
    {
        return new MockEmailService();
    }
}
