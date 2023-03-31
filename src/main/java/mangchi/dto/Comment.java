package mangchi.dto;

import java.time.LocalDateTime;

public class Comment {
    private int commentNo;
    private String commentContent;
    private String commentWriter;
    private LocalDateTime commentWriteTime;
    private int boardNo;



    public Comment(int commentNo, String commentContent, String commentWriter, LocalDateTime commentWriteTime, int boardNo
    ) {
        this.commentNo = commentNo;
        this.commentContent = commentContent;
        this.commentWriter = commentWriter;
        this.commentWriteTime = commentWriteTime;
        this.boardNo = boardNo;
    }
    public Comment(){

    }

    public void setCommentNo(int commentNo) {
        this.commentNo = commentNo;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public void setCommentWriter(String commentWriter) {
        this.commentWriter = commentWriter;
    }

    public void setCommentWriteTime(LocalDateTime commentWriteTime) {
        this.commentWriteTime = commentWriteTime;
    }

    public int getCommentNo() {
        return commentNo;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public String getCommentWriter() {
        return commentWriter;
    }

    public LocalDateTime getCommentWriteTime() {
        return commentWriteTime;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public int getBoardNo() {
        return boardNo;
    }

}
