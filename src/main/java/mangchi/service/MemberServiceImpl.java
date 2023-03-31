package mangchi.service;

import lombok.RequiredArgsConstructor;
import mangchi.dto.Member;
import mangchi.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Override
    public void createMember(Member member) {
        memberRepository.insertMember(member);
    }

    @Override
    public Member retrieveMember(int memberNo) {
        return memberRepository.selectMember(memberNo);
    }
    @Override
    public Member retrieveMemberByMemberId(String memberId) {
        return memberRepository.findMemberByMemberId(memberId);
    }

    @Override
    public boolean isMatched(Member member) {
        Member dbMember = memberRepository.findMemberByMemberId(member.getMemberId());
        if (Objects.isNull(dbMember)) {
            return false;
        }
        if(Objects.equals(member.getMemberPw(), dbMember.getMemberPw())){
            return true;
        }
        return false;
    }

    @Override
    public void modifyMember(Member member) {
        memberRepository.updateMember(member);
    }

    @Override
    public void removeMember(int memberNo) {
        memberRepository.deleteMember(memberNo);
    }

    @Override
    public List<Member> retrieveAll() {
        return memberRepository.findAll();
    }

    @Override
    public String findMemberNameByMemberNo(int memberNo) {
        Member member = memberRepository.selectMember(memberNo);
        return member.getMemberName();
    }


}
