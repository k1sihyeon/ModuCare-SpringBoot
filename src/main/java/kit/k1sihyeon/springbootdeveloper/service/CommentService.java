package kit.k1sihyeon.springbootdeveloper.service;

import kit.k1sihyeon.springbootdeveloper.domain.Comment;
import kit.k1sihyeon.springbootdeveloper.domain.Log;
import kit.k1sihyeon.springbootdeveloper.domain.User;
import kit.k1sihyeon.springbootdeveloper.dto.AddCommentRequest;
import kit.k1sihyeon.springbootdeveloper.repository.CommentRepository;
import kit.k1sihyeon.springbootdeveloper.repository.LogRepository;
import kit.k1sihyeon.springbootdeveloper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final LogRepository logRepository;

    public Comment addComment(AddCommentRequest request) {
        User user = userRepository.findById(request.getUsrId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id"));

        Log log = logRepository.findById(request.getLogId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid log id"));

        return commentRepository.save(request.toEntity(user, log));
    }
}
