package org.example.springendava.ch5;

import org.example.springendava.ch5.services.CommentService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"org.example.springendava.ch5.services", "org.example.springendava.ch5.repositories"})
public class ProjectConfig {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CommentService commentService() {
        return new CommentService();
    }

//    @Bean
//    public CommentService commentService() {
//        return new CommentService();
//    }

}
