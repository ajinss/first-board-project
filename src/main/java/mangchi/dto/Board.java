package mangchi.dto;

import lombok.ToString;

import java.time.LocalDateTime;


@ToString
public class Board {
    private int boardNo;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime writeTime;

    private int member_no;

    public Board(){

    }
    public Board(int boardNo, String title, String content, String writer, LocalDateTime writeTime, int memberNo) {
        this.boardNo = boardNo;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.writeTime = writeTime;
        this.member_no = memberNo;
    }

    public int getMember_no() {
        return member_no;
    }

    public void setMember_no(int member_no) {
        this.member_no = member_no;
    }

    public int getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public LocalDateTime getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(LocalDateTime writeTime) {
        this.writeTime = writeTime;
    }
}

