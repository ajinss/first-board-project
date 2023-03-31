package mangchi.service;

import mangchi.dto.Comment;
import mangchi.repository.CommentRepository;

import java.util.List;

public interface CommentService {
    void createComment(Comment comment);
    Comment retrieveComment(int commentNo);
    void modifyComment(Comment comment);
    void removeComment(int commentNo);
    List<Comment> retrieveCommentsByBoardNo(int boardNo);
}
