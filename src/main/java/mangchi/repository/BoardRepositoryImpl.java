package mangchi.repository;

import mangchi.dto.Board;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class BoardRepositoryImpl implements BoardRepository{
    private final JdbcTemplate jdbcTemplate ;

    public BoardRepositoryImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<Board> rowMapper = (resultSet, rowNum) ->{
        Board board = new Board(
                resultSet.getInt("board_no"),
                resultSet.getString("title"),
                resultSet.getString("content"),
                resultSet.getString("writer"),
                resultSet.getTimestamp("write_time").toLocalDateTime(),
                resultSet.getInt("member_no")
        );
        return board;
        };


    @Override
    public void writePost(Board board) {
        jdbcTemplate.update("insert into board values(null,?,?,?,now(),?)",board.getTitle(),board.getContent(),board.getWriter(),board.getMember_no());

    }

    @Override
    public Board readPost(int boardNo) {
        return jdbcTemplate.queryForObject("select * from board where board_no=?",rowMapper,boardNo);
    }

    @Override
    public void updatePost(Board board) {
        jdbcTemplate.update("update board set title=?, content=?, writer=? where board_no=?",board.getTitle(),board.getContent(),board.getWriter(),board.getBoardNo());

    }

    @Override
    public void deletePost(int boardNo) {
        jdbcTemplate.update("delete from board where board_no=?", boardNo);

    }

    @Override
    public List<Board> readAll() {
        return jdbcTemplate.query("select * from board", rowMapper);
    }

    @Override
    public List<Board> findMyPosts(int memberNo) {
        return jdbcTemplate.query("select * from board where member_no=?", rowMapper, memberNo);
    }

}
