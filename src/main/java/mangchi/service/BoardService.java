package mangchi.service;

import mangchi.dto.Board;

import java.util.List;

public interface BoardService {
    void posting(Board board);
    Board viewPost(int boardNo);
    void modifyPost(Board board);
    void removePost(int boardNo);
    List<Board> viewAll();
    List<Board> viewMyPosts(int memberNo);
}
