package mangchi.service;

import mangchi.dto.Board;
import mangchi.repository.BoardRepository;
import mangchi.repository.BoardRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository; //속성
    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository){ //외부의 값을 받아오는 매개변수
        this.boardRepository = boardRepository; //비어 있는 this.boardRepository(속성)에 외부에서 값을 받아온 boardRepository(매개변수)를 넣는다.
    } //생성자

    @Override
    public void posting(Board board) {
        boardRepository.writePost(board);
    }

    @Override
    public Board viewPost(int boardNo) {
        return boardRepository.readPost(boardNo);
    }

    @Override
    public void modifyPost(Board board) {
        boardRepository.updatePost(board);
    }

    @Override
    public void removePost(int boardNo) {
        boardRepository.deletePost(boardNo);
    }

    @Override
    public List<Board> viewAll() {
        return boardRepository.readAll();
    }

    @Override
    public List<Board> viewMyPosts(int memberNo) {
        return boardRepository.findMyPosts(memberNo);
    }

}
