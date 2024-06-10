package kit.k1sihyeon.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "camera")
public class Camera {

    @Id @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cam_id", nullable = false)
    private Long id;

    @Column(name = "cam_location")
    private String location;

    @Column(name = "cam_latitude")
    private Double latitude;

    @Column(name = "cam_longitude")
    private Double longitude;

    @Builder
    public Camera(String location, Double latitude, Double longitude) {
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
