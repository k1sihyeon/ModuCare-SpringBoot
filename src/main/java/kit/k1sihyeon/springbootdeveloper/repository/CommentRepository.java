package kit.k1sihyeon.springbootdeveloper.repository;

import kit.k1sihyeon.springbootdeveloper.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
