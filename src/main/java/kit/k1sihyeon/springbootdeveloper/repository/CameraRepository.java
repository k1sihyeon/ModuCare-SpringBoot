package kit.k1sihyeon.springbootdeveloper.repository;

import kit.k1sihyeon.springbootdeveloper.domain.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CameraRepository extends JpaRepository<Camera, Long> {
}
