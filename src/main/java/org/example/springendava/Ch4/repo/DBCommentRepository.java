package org.example.springendava.Ch4.repo;

import org.example.springendava.Ch4.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class DBCommentRepository implements CommentRepository {

    @Override
    public void storeComment(Comment comment) {

        System.out.println("Storing comment: " + comment.getText());

    }

}
