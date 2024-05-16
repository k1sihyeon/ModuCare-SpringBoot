package kit.k1sihyeon.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "log", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public void check() {
        this.isChecked = true;
    }

    public void addComment(Comment comment) {
        if (comments == null) {
            comments = new ArrayList<>();
        }
        comments.add(comment);
        comment.setLog(this);
    }
}
