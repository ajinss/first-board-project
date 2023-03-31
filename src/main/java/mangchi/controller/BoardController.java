package mangchi.controller;

import mangchi.dto.Board;
import mangchi.dto.Comment;
import mangchi.service.BoardService;
import mangchi.service.CommentService;
import mangchi.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller

public class BoardController {
    private final BoardService boardService;
    private final MemberService memberService;
    private final CommentService commentService;

    @Autowired
    public BoardController(BoardService boardService, MemberService memberService, CommentService commentService){
        this.boardService = boardService;
        this.memberService = memberService;
        this.commentService = commentService;
    }

    @GetMapping("/board")
    public String board(Model model){
        List<Board> list = boardService.viewAll();
        model.addAttribute("list", list);
        return "board";
    }

    @GetMapping("/write")
    public String writeView(){
        return "write";
    }

    @PostMapping("/writing")
    public String write(@ModelAttribute Board board, HttpServletRequest request){
        int memberNo = (int) request.getSession().getAttribute("member_no");
        board.setMember_no(memberNo);
        boardService.posting(board);
        return "redirect:/board";
    }

    @GetMapping("/board/{boardNo}")
    public String readBoardNo(@PathVariable int boardNo, Model model){
        List<Comment> comments = commentService.retrieveCommentsByBoardNo(boardNo);
        Board board = boardService.viewPost(boardNo);
        model.addAttribute("post", board);
        model.addAttribute("comments",comments);
        return "post";
    }

    @GetMapping("/board/{boardNo}/edit")
    public String editPost(@PathVariable int boardNo, Model model){
        model.addAttribute("board_no", boardNo);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Board board){
        boardService.modifyPost(board);
        return "redirect:/board/"+board.getBoardNo();
    }

    @GetMapping("/board/{boardNo}/delete")
    public String deletePost(@PathVariable int boardNo){
        boardService.removePost(boardNo);
        return "redirect:/board";
    }

}
