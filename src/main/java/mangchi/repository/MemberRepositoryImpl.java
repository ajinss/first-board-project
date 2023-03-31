package mangchi.repository;

import mangchi.dto.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class MemberRepositoryImpl implements MemberRepository{
    private final JdbcTemplate jdbcTemplate;

    public MemberRepositoryImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<Member> rowMapper = (resultSet, rowNum) ->{
        Member member = new Member(
                resultSet.getInt("member_no"),
                resultSet.getString("member_id"),
                resultSet.getString("member_pw"),
                resultSet.getString("member_name")
        );
        return member;
    };


    @Override
    public void insertMember(Member member) {
        jdbcTemplate.update("insert into members values (null,?,?,?)",member.getMemberId(),member.getMemberPw(),member.getMemberName());
    }

    @Override
    public Member selectMember(int memberNo) {
        return jdbcTemplate.queryForObject("select * from members where member_no=?",rowMapper,memberNo);
    }

    @Override
    public Member findMemberByMemberId(String memberId) {
        return jdbcTemplate.queryForObject("select * from members where member_id=?",rowMapper,memberId);
    }


    @Override
    public void updateMember(Member member) {
        jdbcTemplate.update("update members set member_pw=? where member_no=?",member.getMemberPw(),member.getMemberNo());
    }

    @Override
    public void deleteMember(int memberNo) {
        jdbcTemplate.update("delete from members where member_no=?",memberNo);
    }

    @Override
    public List<Member> findAll() {
        return jdbcTemplate.query("select * from members",rowMapper);
    }

}
