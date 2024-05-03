package kit.k1sihyeon.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
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

    @Column(name = "cmt_usr_id", nullable = false)
    private String userId;

    @Column(name = "cmt_log_id", nullable = false)
    private Long logId;

    private String content;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "cmt_usr_id", referencedColumnName = "usr_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "cmt_log_id", referencedColumnName = "log_id", insertable = false, updatable = false)
    private Log log;
}
