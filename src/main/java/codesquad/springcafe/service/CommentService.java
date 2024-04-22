package codesquad.springcafe.service;

import codesquad.springcafe.model.Comment;
import codesquad.springcafe.model.UpdatedComment;
import java.util.List;

public interface CommentService {
    void addComment(Comment comment);

    Comment findCommentsById(long id);

    List<Comment> findCommentsByAid(long articleId);

    List<Comment> findCommentsByUserId(String userId);

    void updateComment(long id, UpdatedComment comment); // FIXME

    void deleteComment(long id); // FIXME
}