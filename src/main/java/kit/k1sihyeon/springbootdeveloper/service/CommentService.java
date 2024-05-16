package kit.k1sihyeon.springbootdeveloper.service;

import kit.k1sihyeon.springbootdeveloper.domain.Comment;
import kit.k1sihyeon.springbootdeveloper.domain.Log;
import kit.k1sihyeon.springbootdeveloper.domain.User;
import kit.k1sihyeon.springbootdeveloper.dto.AddCommentRequest;
import kit.k1sihyeon.springbootdeveloper.dto.CommentResponseDto;
import kit.k1sihyeon.springbootdeveloper.repository.CommentRepository;
import kit.k1sihyeon.springbootdeveloper.repository.LogRepository;
import kit.k1sihyeon.springbootdeveloper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final LogRepository logRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, UserRepository userRepository, LogRepository logRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.logRepository = logRepository;
    }

    public Comment addComment(AddCommentRequest request, Long logId) {
        User user = userRepository.findById(request.getUsrId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id"));

        Log log = logRepository.findById(logId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid log id"));

        Comment comment = request.toEntity(user, log);
        log.addComment(comment);

        return commentRepository.save(comment);
    }

    public List<CommentResponseDto> findByLog(Long id) {
        Log log = logRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid log id"));

        return log.getComments().stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());
    }


}
