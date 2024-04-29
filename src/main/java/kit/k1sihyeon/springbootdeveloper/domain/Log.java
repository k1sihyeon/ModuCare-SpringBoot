package kit.k1sihyeon.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "log")
public class Log {

    @Id @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id", nullable = false)
    private Long id;

    @Column(name = "cmt_id")
    private Long cmtId;

    @Column(name = "cam_id", nullable = false)
    private Long camId;

    private String content;
    private String imagePath;
    private LocalDateTime createdAt;
    private Boolean isChecked;

    @Builder
    public Log(Long cmtId, Long camId, String content, String imagePath, LocalDateTime createdAt, Boolean isChecked) {
        this.cmtId = cmtId;
        this.camId = camId;
        this.content = content;
        this.imagePath = imagePath;
        this.createdAt = createdAt;
        this.isChecked = isChecked;
    }

    public void check() {
        this.isChecked = true;
    }

    @ManyToOne
    @JoinColumn(name = "cmt_id", referencedColumnName = "cmt_id", insertable = false, updatable = false)
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "cam_id", referencedColumnName = "cam_id", insertable = false, updatable = false)
    private Camera camera;

}
