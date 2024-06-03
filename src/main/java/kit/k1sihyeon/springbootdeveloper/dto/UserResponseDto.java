package kit.k1sihyeon.springbootdeveloper.dto;

import kit.k1sihyeon.springbootdeveloper.domain.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private String name;
    private String email;
    private String position;

    public UserResponseDto(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.position = user.getPosition();
    }
}
