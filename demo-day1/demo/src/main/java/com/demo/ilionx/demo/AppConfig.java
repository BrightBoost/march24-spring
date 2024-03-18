package com.demo.ilionx.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
    @Bean()
    public String getStringBean() {
        return "Blabla";
    }

    @Bean
    @Primary
    public String getStringBean2() {
        return "Lala";
    }
}
