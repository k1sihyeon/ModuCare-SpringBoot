package kit.k1sihyeon.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "log")
public class Log {

    @Id @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id", nullable = false)
    private Long id;

    @ManyToOne(targetEntity = Camera.class)
    @JoinColumn(name = "cam", nullable = false)
    private Camera camera;

    private String content;
    private String imagePath;
    private LocalDateTime createdAt;
    private Boolean isChecked;

    public void check() {
        this.isChecked = true;
    }
}
