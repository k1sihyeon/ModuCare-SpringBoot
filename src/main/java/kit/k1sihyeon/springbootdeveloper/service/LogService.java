package kit.k1sihyeon.springbootdeveloper.service;

import kit.k1sihyeon.springbootdeveloper.domain.Camera;
import kit.k1sihyeon.springbootdeveloper.domain.Comment;
import kit.k1sihyeon.springbootdeveloper.domain.Log;
import kit.k1sihyeon.springbootdeveloper.domain.User;
import kit.k1sihyeon.springbootdeveloper.dto.AddLogRequest;
import kit.k1sihyeon.springbootdeveloper.repository.CameraRepository;
import kit.k1sihyeon.springbootdeveloper.repository.CommentRepository;
import kit.k1sihyeon.springbootdeveloper.repository.LogRepository;
import kit.k1sihyeon.springbootdeveloper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LogService {
    private final LogRepository logRepository;
    private final CameraRepository cameraRepository;
    private final CommentRepository commentRepository;

    public Log addLog(AddLogRequest request) {
        Camera camera = cameraRepository.findById(request.getCamId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid camera id"));

        return logRepository.save(request.toEntity(camera));
    }
}
