package mangchi.service;

import mangchi.dto.Member;

import java.util.List;

public interface MemberService {
    void createMember(Member member);
    Member retrieveMember(int memberNo);
    Member retrieveMemberByMemberId(String memberId);
    boolean isMatched(Member member);
    void modifyMember(Member member);
    void removeMember(int memberNo);
    List<Member> retrieveAll();
    String findMemberNameByMemberNo(int memberNo);

}
