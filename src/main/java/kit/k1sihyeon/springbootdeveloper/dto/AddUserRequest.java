package kit.k1sihyeon.springbootdeveloper.dto;

import kit.k1sihyeon.springbootdeveloper.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddUserRequest {
    private String id;
    private String password;
    private String name;
    private String email;
    private String position;

    public User toEntity() {
        return User.builder()
                .id(id)
                .password(password)
                .name(name)
                .email(email)
                .position(position)
                .build();
    }
}
