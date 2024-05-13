package kit.k1sihyeon.springbootdeveloper.service;

import kit.k1sihyeon.springbootdeveloper.domain.Comment;
import kit.k1sihyeon.springbootdeveloper.domain.Log;
import kit.k1sihyeon.springbootdeveloper.domain.User;
import kit.k1sihyeon.springbootdeveloper.dto.AddCommentRequest;
import kit.k1sihyeon.springbootdeveloper.repository.CommentRepository;
import kit.k1sihyeon.springbootdeveloper.repository.LogRepository;
import kit.k1sihyeon.springbootdeveloper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public Comment addComment(AddCommentRequest request) {
        User user = userRepository.findById(request.getUsrId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id"));

        Log log = logRepository.findById(request.getLogId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid log id"));

        Comment comment = new Comment();
        comment.setContent(request.getContent());
        comment.setCreatedAt(request.getCreatedAt());
        comment.setUser(user);
        comment.setLog(log);

        return commentRepository.save(comment);
    }

    public Comment getComment(Long id) {

        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid comment id"));

        User user = comment.getUser();


        return comment;
    }
}
