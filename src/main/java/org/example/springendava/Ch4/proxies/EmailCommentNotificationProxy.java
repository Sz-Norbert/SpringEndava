package org.example.springendava.Ch4.proxies;

import org.example.springendava.Ch4.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Email")
public class EmailCommentNotificationProxy implements CommentNotificationProxy {


    @Override
    public void sendComment(Comment comment) {

        System.out.println("Sending notification for comment: " + comment.getText());

    }

}
