package org.example.springendava.ch5;

import org.example.springendava.ch5.services.CommentService;
import org.example.springendava.ch5.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public   static void main(String[] args) {



        var c = new AnnotationConfigApplicationContext(
                ProjectConfig.class);

        var cs1 = c.getBean(CommentService.class);
        var cs2 = c.getBean(UserService.class);

        boolean b1 = cs1.getCommentRepository() == cs2.getCommentRepository();

        System.out.println(b1);

        System.out.println("Before retrieving the CommentService");
        var service = c.getBean(CommentService.class);
        System.out.println("After retrieving the CommentService");

        var s1 = c.getBean(CommentService.class);
        var s2 = c.getBean(UserService.class);

        boolean b = s1.getCommentRepository() == s2.getCommentRepository();

        System.out.println(b);
    }

}
