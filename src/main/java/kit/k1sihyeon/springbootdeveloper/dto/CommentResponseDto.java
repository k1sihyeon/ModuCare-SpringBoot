package kit.k1sihyeon.springbootdeveloper.dto;

import kit.k1sihyeon.springbootdeveloper.domain.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private Long id;
    private String content;
    private String userName;
    private String userPosition;
    private LocalDateTime createdAt;
    private Long logId;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.userName = comment.getUser().getName();
        this.userPosition = comment.getUser().getPosition();
        this.createdAt = comment.getCreatedAt();
        this.logId = comment.getLog().getId();
    }
}
