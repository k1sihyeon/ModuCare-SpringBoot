package kit.k1sihyeon.springbootdeveloper.dto;

import kit.k1sihyeon.springbootdeveloper.domain.Comment;
import kit.k1sihyeon.springbootdeveloper.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddCommentRequest {
    private String usrId;
    private String content;
    private LocalDateTime createdAt;

    public Comment toEntity(User user) {

        this.usrId = user.getId();

        return Comment.builder()
                .userId(usrId)
                .content(content)
                .createdAt(createdAt)
                .build();
    }
}
