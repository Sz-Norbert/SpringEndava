package org.example.springendava.Ch4.services;

import org.example.springendava.Ch4.Comment;
import org.example.springendava.Ch4.proxies.CommentNotificationProxy;
import org.example.springendava.Ch4.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CommentServices {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;


    public CommentServices(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
