package mangchi.controller;

import mangchi.dto.Comment;
import mangchi.service.BoardService;
import mangchi.service.CommentService;
import mangchi.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommentController {
    private CommentService commentService;
    private BoardService boardService;
    private MemberService memberService;

    public CommentController(CommentService commentService, BoardService boardService,MemberService memberService){
        this.commentService = commentService;
        this.boardService = boardService;
        this.memberService = memberService;
    }

    @PostMapping("/board/{boardNo}/comment-post")
    public String writeComment(@PathVariable int boardNo, @ModelAttribute Comment comment, HttpServletRequest request){
        int memberNo = (int)request.getSession().getAttribute("member_no");
        comment.setBoardNo(boardNo);
        comment.setCommentWriter(memberService.findMemberNameByMemberNo(memberNo));
        commentService.createComment(comment);
        return "redirect:/board/{boardNo}";
    }

    @PostMapping("/board/{boardNo}/{commentNo}/comment-edit")
    public String editComment(@PathVariable int boardNo, @ModelAttribute Comment comment){
        boardService.viewPost(boardNo);
        commentService.modifyComment(comment);
        return "redirect:/board/{boardNo}";
    }

    @GetMapping("/board/{boardNo}/{commentNo}/comment-remove")
    public String deleteComment(@PathVariable int boardNo, @PathVariable int commentNo){
        boardService.viewPost(boardNo);
        commentService.removeComment(commentNo);
        return "redirect:/board/{boardNo}";
    }








}
