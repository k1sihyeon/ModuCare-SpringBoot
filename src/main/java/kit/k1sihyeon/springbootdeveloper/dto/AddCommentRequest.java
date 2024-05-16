package kit.k1sihyeon.springbootdeveloper.dto;

import kit.k1sihyeon.springbootdeveloper.domain.Comment;
import kit.k1sihyeon.springbootdeveloper.domain.Log;
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
    private Long logId;
    private String content;
    private LocalDateTime createdAt;

    public Comment toEntity(User user, Log log) {
        return Comment.builder()
                .user(user)
                .log(log)
                .content(content)
                .createdAt(createdAt)
                .build();
    }

}
