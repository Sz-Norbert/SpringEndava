package org.example.springendava.ch6;

import org.example.springendava.ch6.model.Comment;
import org.example.springendava.ch6.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface ToLog {

    }

   public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = c.getBean(CommentService.class);

        Comment comment = new Comment("Demo comment", "Natasha");

        service.publishComment(comment);

    }

}
