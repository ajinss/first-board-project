package mangchi.repository;

import mangchi.dto.Board;

import java.util.List;

public interface BoardRepository {
    void writePost(Board board);
    Board readPost(int boardNo);
    void updatePost(Board board);
    void deletePost(int boardNo);
    List<Board> readAll();
    List<Board> findMyPosts(int memberNo);


}
