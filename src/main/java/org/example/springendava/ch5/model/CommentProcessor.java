package org.example.springendava.ch5.model;

import org.example.springendava.ch5.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentProcessor {

    @Autowired
    private CommentRepository commentRepository;
    private Comment comment;

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Comment getComment() {
        return comment;
    }

    public void processComment(Comment comment) {
        System.out.println("Processing comment");
    }

    public void validateComment(Comment comment) {
        System.out.println("Validating comment");
    }

}
