package kit.k1sihyeon.springbootdeveloper.dto;

import kit.k1sihyeon.springbootdeveloper.domain.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {
    private Long id;
    private String content;
    private String userName;
    private String userPosition;
    private Long logId;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.userName = comment.getUser().getName();
        this.userPosition = comment.getUser().getPosition();
        this.logId = comment.getLog().getId();
    }
}
