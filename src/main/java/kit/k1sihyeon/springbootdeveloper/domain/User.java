package kit.k1sihyeon.springbootdeveloper.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "\"user\"")
public class User {

    @Id @Getter
    @Column(name = "user_id", nullable = false)
    private String id;

    @JsonIgnore
    @Column(name = "user_pwd", nullable = false)
    private String password;

    @Column(name = "user_name", nullable = false)
    private String name;

    @JsonIgnore
    private String email;
    private String position;

}
