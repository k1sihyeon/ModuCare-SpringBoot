package kit.k1sihyeon.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user")
public class User {

    @Id @Getter
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id", nullable = false)
    private String id;

    @Column(name = "usr_pwd", nullable = false)
    private String password;

    @Column(name = "usr_name", nullable = false)
    private String name;

    @Column(name = "usr_email", nullable = false)
    private String email;

    @Column(name = "usr_pos", nullable = false)
    private String position;

    @Builder
    public User(String id, String password, String name, String email, String position) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.position = position;
    }

}
