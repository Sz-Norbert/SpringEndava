package org.example.springendava.Ch4;

import org.example.springendava.Ch4.services.CommentServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

   public static void main(String[] args) {
        var context =
                new AnnotationConfigApplicationContext(
                        ProjectConfiguration.class);

        var comment = new Comment();
        comment.setAuthor("Norbert");
        comment.setText("Demo comment");

        var commentService = context.getBean(CommentServices.class);
        commentService.publishComment(comment);

    }

//    public static void main(String[] args) {
//        var commentRepository = new DBCommentRepository();
//        EmailCommentNotificationProxy commentNotificationProxy;
//        commentNotificationProxy = new EmailCommentNotificationProxy();
//
//        var commentService = new CommentService(commentRepository, commentNotificationProxy);
//
//        var comment = new Comment();
//        comment.setAuthor("Laurentiu");
//        comment.setText("Demo comment");
//
//        commentService.publishComment(comment);
//    }

}
