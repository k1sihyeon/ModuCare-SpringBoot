package kit.k1sihyeon.springbootdeveloper.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "comment")
public class Comment {

    @Id @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cmt_id", nullable = false)
    private Long id;

    @ManyToOne @Setter
    @JoinColumn(name = "cmt_usr_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @ManyToOne @Setter @Getter
    @JoinColumn(name = "cmt_log_id", referencedColumnName = "log_id", nullable = false)
    private Log log;

    private String content;
    private LocalDateTime createdAt;
}
