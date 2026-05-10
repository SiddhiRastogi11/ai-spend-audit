package com.siddhi.aispendaudit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AiSpendAuditApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiSpendAuditApplication.class, args);
    }
    @Bean
    public org.springframework.web.client.RestTemplate restTemplate() {
        return new org.springframework.web.client.RestTemplate();
    }
}

