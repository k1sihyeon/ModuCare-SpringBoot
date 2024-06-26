package kit.k1sihyeon.springbootdeveloper.dto;

import kit.k1sihyeon.springbootdeveloper.domain.Camera;
import kit.k1sihyeon.springbootdeveloper.domain.Log;
import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
public class LogResponseDto {
    private Long logId;
    private String location;
    private Double latitude;
    private Double longitude;
    private String content;
    private String imagePath;
    private String createdAt;
    private Boolean isChecked;
    //private List<CommentResponseDto> comments;

    public LogResponseDto(Log log) {
        this.logId = log.getId();
        this.location = log.getCamera().getLocation();
        this.latitude = log.getCamera().getLatitude();
        this.longitude = log.getCamera().getLongitude();
        this.content = log.getContent();
        this.imagePath = log.getImagePath();
        this.createdAt = log.getCreatedAt().toString();
        this.isChecked = log.getIsChecked();
//        this.comments = Optional.ofNullable(log.getComments())
//                .orElse(Collections.emptyList())
//                .stream()
//                .map(CommentResponseDto::new)
//                .collect(Collectors.toList());
    }

}
