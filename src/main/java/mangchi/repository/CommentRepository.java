package mangchi.repository;

import mangchi.dto.Comment;

import java.util.List;

public interface CommentRepository {
    void writeComment(Comment comment);
    Comment readComment(int commentNo);
    void updateComment(Comment comment);
    void deleteComment(int commentNo);
    List<Comment> readCommentsByBoardNo(int boardNo);

}
