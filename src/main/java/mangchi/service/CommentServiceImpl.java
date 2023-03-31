package mangchi.service;

import mangchi.dto.Comment;
import mangchi.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;
    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void createComment(Comment comment) {
        commentRepository.writeComment(comment);
    }

    @Override
    public Comment retrieveComment(int commentNo) {
        return commentRepository.readComment(commentNo);
    }

    @Override
    public void modifyComment(Comment comment) {
        commentRepository.updateComment(comment);

    }

    @Override
    public void removeComment(int commentNo) {
        commentRepository.deleteComment(commentNo);
    }

    @Override
    public List<Comment> retrieveCommentsByBoardNo(int boardNo) {
        return commentRepository.readCommentsByBoardNo(boardNo);
    }
}
