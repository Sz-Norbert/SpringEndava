package org.example.springendava.Ch4.proxies;

import org.example.springendava.Ch4.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PUSH")
public class CommentPushNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println(
                "Sending push notification for comment: "
                        + comment.getText());
    }
}