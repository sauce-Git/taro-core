package com.tarot.core.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GPTConfig {

    @Value("${openai.secret-key}")
    private String secretKey;
    @Getter
    @Value("${openai.model}")
    private String model;
    @Getter
    @Value("${openai.max-tokens}")
    private int maxTokens;
    @Getter
    @Value("${openai.api-url}")
    private String apiBase;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().set(HttpHeaders.AUTHORIZATION, "Bearer " + secretKey);
            request.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return execution.execute(request, body);
        });
        return restTemplate;
    }
}
