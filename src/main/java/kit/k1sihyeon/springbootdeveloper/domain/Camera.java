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

    @Column(name = "cam_location", nullable = false)
    private String location;

    @Builder
    public Camera(String location) {
        this.location = location;
    }

}
