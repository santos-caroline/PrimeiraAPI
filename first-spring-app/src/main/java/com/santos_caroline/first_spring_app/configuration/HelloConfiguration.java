package com.santos_caroline.first_spring_app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfiguration {
    @Bean
    public SDKAWS sdkaws(){
            return new SDKAWS();
    }
}
