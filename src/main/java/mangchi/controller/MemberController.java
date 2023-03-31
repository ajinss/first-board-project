package mangchi.controller;

import lombok.RequiredArgsConstructor;
import mangchi.dto.Board;
import mangchi.dto.Member;
import mangchi.service.BoardService;
import mangchi.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;
    private final BoardService boardService;

    @Autowired
    public MemberController(MemberService memberService, BoardService boardService){
        this.memberService = memberService;
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String home(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Member member, HttpServletRequest request
    ){
        if(memberService.isMatched(member)){
            int memberNo = memberService.retrieveMemberByMemberId(member.getMemberId()).getMemberNo();
            request.getSession().setAttribute("member_no", memberNo);

            return "redirect:/member-board";
        }
        return "redirect:";
    }
    @GetMapping("/member-board")
    public String memberBoard(){
        return "member-board";
    }


    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register-member")
    public String registerMember(@ModelAttribute Member member){
        memberService.createMember(member);
        return "redirect:";
    }

    @GetMapping("/members/{memberNo}")
    public String readMember(@PathVariable int memberNo, Model model){
        Member member = memberService.retrieveMember(memberNo);
        model.addAttribute("member", member);
        return "member";
    }

    @GetMapping("/members/{memberNo}/posts")
    public String findMemberPosts(@PathVariable int memberNo, Model model){
        List<Board> board = boardService.viewMyPosts(memberNo);
        model.addAttribute("posts", board);
        return "my-board";
    }

    @GetMapping("/members/{memberNo}/update")
    public String update(@PathVariable int memberNo, Model model){
        model.addAttribute("member_no",memberNo);
        return "update";
    }

    @PostMapping("/update")
    public String updateMember(@ModelAttribute Member member){
        memberService.modifyMember(member);
        return "redirect:/members/"+member.getMemberNo();
    }

    @GetMapping("/members/{memberNo}/delete")
    public String deleteMember(@PathVariable int memberNo){
        memberService.removeMember(memberNo);
        return "redirect:/members";
    }

    @GetMapping("/members")
    public String readAllMember(Model model){
        List<Member> list = memberService.retrieveAll();
        model.addAttribute("list",list);
        return "member-list";
    }
}
