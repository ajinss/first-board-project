package mangchi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private int memberNo;
    private String memberId;
    private String memberPw;
    private String memberName;

    public Member(int memberNo, String memberId, String memberPw, String memberName) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
    }

    public Member(){
    }
}
