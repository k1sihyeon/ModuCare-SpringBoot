package kit.k1sihyeon.springbootdeveloper.dto;

import kit.k1sihyeon.springbootdeveloper.domain.Camera;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddCameraRequest {

    private String location;
    private Double latitude;
    private Double longitude;

    public Camera toEntity() {
        return Camera.builder()
                .location(location)
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }
}
