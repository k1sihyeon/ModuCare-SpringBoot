package kit.k1sihyeon.springbootdeveloper.controller;

import kit.k1sihyeon.springbootdeveloper.domain.Comment;
import kit.k1sihyeon.springbootdeveloper.dto.AddCommentRequest;
import kit.k1sihyeon.springbootdeveloper.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final CommentService commentService;

    @RequestMapping("/api/comments")
    public Comment addComment(AddCommentRequest request) {
        return commentService.addComment(request);
    }
}