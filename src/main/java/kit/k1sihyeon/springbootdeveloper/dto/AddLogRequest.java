package kit.k1sihyeon.springbootdeveloper.dto;

import kit.k1sihyeon.springbootdeveloper.domain.Camera;
import kit.k1sihyeon.springbootdeveloper.domain.Comment;
import kit.k1sihyeon.springbootdeveloper.domain.Log;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddLogRequest {
    private Long cmtId;
    private Long camId;
    private String content;
    private String imagePath;
    private LocalDateTime createdAt;
    private Boolean isChecked;

    public void check() {
        this.isChecked = true;
    }

    public Log toEntity(Camera camera, Comment comment) {

        this.camId = camera.getId();
        this.cmtId = comment.getId();

        return Log.builder()
                .cmtId(cmtId)
                .camId(camId)
                .content(content)
                .imagePath(imagePath)
                .createdAt(createdAt)
                .isChecked(isChecked)
                .build();
    }
}
