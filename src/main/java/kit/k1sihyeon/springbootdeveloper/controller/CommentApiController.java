package kit.k1sihyeon.springbootdeveloper.controller;

import kit.k1sihyeon.springbootdeveloper.domain.Comment;
import kit.k1sihyeon.springbootdeveloper.domain.Log;
import kit.k1sihyeon.springbootdeveloper.dto.AddCommentRequest;
import kit.k1sihyeon.springbootdeveloper.dto.CommentResponseDto;
import kit.k1sihyeon.springbootdeveloper.repository.CommentRepository;
import kit.k1sihyeon.springbootdeveloper.repository.LogRepository;
import kit.k1sihyeon.springbootdeveloper.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentApiController {

    private final CommentService commentService;

    @Autowired
    public CommentApiController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/api/logs/{logId}/comments")
    public ResponseEntity<CommentResponseDto> addComment(@PathVariable Long logId, @RequestBody AddCommentRequest request) {
        CommentResponseDto dto = new CommentResponseDto(commentService.addComment(request, logId));

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/api/logs/{logId}/comments")
    public ResponseEntity<List<CommentResponseDto>> getLogComment(@PathVariable Long logId) {
        List<CommentResponseDto> comments = commentService.findByLog(logId);

        return ResponseEntity.ok(comments);
    }

}

