package org.example.springendava.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(
        basePackages = "org.example.springendava"
)
public class ProjectConfig {
}
