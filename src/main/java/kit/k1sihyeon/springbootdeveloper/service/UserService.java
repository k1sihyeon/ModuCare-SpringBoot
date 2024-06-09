package kit.k1sihyeon.springbootdeveloper.service;


import kit.k1sihyeon.springbootdeveloper.domain.User;
import kit.k1sihyeon.springbootdeveloper.dto.AddUserRequest;
import kit.k1sihyeon.springbootdeveloper.dto.UserResponseDto;
import kit.k1sihyeon.springbootdeveloper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public User addUser(AddUserRequest request) {
        return userRepository.save(request.toEntity());
    }

    public UserResponseDto getUser(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id"));

        return new UserResponseDto(user);
    }

}
