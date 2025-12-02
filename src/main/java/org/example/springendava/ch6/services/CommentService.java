package org.example.springendava.ch6.services;

import org.example.springendava.ch6.Main;
import org.example.springendava.ch6.model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
    private final Logger logger = Logger.getLogger(CommentService.class.getName());


    @Main.ToLog
    public String publishComment(Comment comment){
        logger.info("Publishing Comment " + comment.text() );
        return "Success";
    }
}
