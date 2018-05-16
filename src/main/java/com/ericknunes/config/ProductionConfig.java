package com.ericknunes.config;

import com.ericknunes.backend.service.EmailService;
import com.ericknunes.backend.service.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("prod")
@PropertySource("file:///D:/Projetos/.ericknunes/application-prod.properties")
public class ProductionConfig {

    @Bean
    public EmailService emailService()
    {
        return new SmtpEmailService();
    }
}
