package kit.k1sihyeon.springbootdeveloper.controller;

import kit.k1sihyeon.springbootdeveloper.domain.User;
import kit.k1sihyeon.springbootdeveloper.dto.AddUserRequest;
import kit.k1sihyeon.springbootdeveloper.dto.UserResponseDto;
import kit.k1sihyeon.springbootdeveloper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserApiController {
    private final UserService userService;

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody AddUserRequest request) {
        User savedUser = userService.addUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable String userId) {
        UserResponseDto user = userService.getUser(userId);

        return ResponseEntity.ok(user);
    }
}
