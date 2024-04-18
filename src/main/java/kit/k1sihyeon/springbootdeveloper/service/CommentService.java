package kit.k1sihyeon.springbootdeveloper.service;

import kit.k1sihyeon.springbootdeveloper.domain.Comment;
import kit.k1sihyeon.springbootdeveloper.domain.User;
import kit.k1sihyeon.springbootdeveloper.dto.AddCommentRequest;
import kit.k1sihyeon.springbootdeveloper.repository.CommentRepository;
import kit.k1sihyeon.springbootdeveloper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public Comment addComment(AddCommentRequest request) {
        User user = userRepository.findById(request.getUsrId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id"));

        return commentRepository.save(request.toEntity(user));
    }
}
