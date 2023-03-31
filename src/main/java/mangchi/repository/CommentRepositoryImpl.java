package mangchi.repository;

import mangchi.dto.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class CommentRepositoryImpl implements CommentRepository{

    private final JdbcTemplate jdbcTemplate;

    public CommentRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    private final RowMapper<Comment> rowMapper = (resultSet, rowNum) ->{
        Comment comment = new Comment(
                resultSet.getInt("comment_no"),
                resultSet.getString("comment_content"),
                resultSet.getString("comment_writer"),
                resultSet.getTimestamp("comment_writeTime").toLocalDateTime(),
                resultSet.getInt("board_no")
        );
        return comment;
    };


    @Override
    public void writeComment(Comment comment) {
        jdbcTemplate.update("insert into comment values(null,?,?,now(),?)",comment.getCommentContent(),comment.getCommentWriter(),comment.getBoardNo());
    }

    @Override
    public Comment readComment(int commentNo) {
        return jdbcTemplate.queryForObject("select * from comment where comment_no=?",rowMapper,commentNo);
    }

    @Override
    public void updateComment(Comment comment) {
        jdbcTemplate.update("update comment set comment_content=? where comment_no=?", comment.getCommentContent(),comment.getCommentNo());

    }

    @Override
    public void deleteComment(int commentNo) {
        jdbcTemplate.update("delete from comment where comment_no=?", commentNo);
    }

    @Override
    public List<Comment> readCommentsByBoardNo(int boardNo) {
        return jdbcTemplate.query("Select * from comment where board_no=?",rowMapper,boardNo);
    }
}
