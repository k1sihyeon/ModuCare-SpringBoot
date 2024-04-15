package kit.k1sihyeon.springbootdeveloper.repository;

import kit.k1sihyeon.springbootdeveloper.domain.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}
