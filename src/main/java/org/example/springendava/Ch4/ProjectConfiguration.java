package org.example.springendava.Ch4;

import org.example.springendava.Ch4.proxies.CommentNotificationProxy;
import org.example.springendava.Ch4.proxies.EmailCommentNotificationProxy;
import org.example.springendava.Ch4.repo.CommentRepository;
import org.example.springendava.Ch4.repo.DBCommentRepository;
import org.example.springendava.Ch4.services.CommentServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"Ch4.proxies", "Ch4.services", "Ch4.repositories"})
public class ProjectConfiguration {


    @Bean
    public CommentRepository commentRepository() {
        return new DBCommentRepository();
    }

    @Bean
    public CommentNotificationProxy commentNotificationProxy() {
        return new EmailCommentNotificationProxy();
    }

    @Bean
    public CommentServices commentService(
            CommentRepository commentRepository,
            CommentNotificationProxy commentNotificationProxy) {
        return new CommentServices(commentRepository, commentNotificationProxy);
    }

}
