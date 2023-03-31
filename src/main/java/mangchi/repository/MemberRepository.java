package mangchi.repository;

import mangchi.dto.Member;

import java.util.List;

public interface MemberRepository {
    void insertMember(Member member);
    Member selectMember(int memberNo);
    Member findMemberByMemberId(String memberId);
    void updateMember(Member member);
    void deleteMember(int memberNo);
    List<Member> findAll();


}
