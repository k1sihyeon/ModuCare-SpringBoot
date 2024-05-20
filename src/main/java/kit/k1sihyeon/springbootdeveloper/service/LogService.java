package kit.k1sihyeon.springbootdeveloper.service;

import kit.k1sihyeon.springbootdeveloper.domain.Camera;
import kit.k1sihyeon.springbootdeveloper.domain.Comment;
import kit.k1sihyeon.springbootdeveloper.domain.Log;
import kit.k1sihyeon.springbootdeveloper.domain.User;
import kit.k1sihyeon.springbootdeveloper.dto.AddLogRequest;
import kit.k1sihyeon.springbootdeveloper.dto.LogResponseDto;
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

        Log log = request.toEntity(camera);

        return logRepository.save(log);
    }

    public LogResponseDto findById(Long id) {
        Log log = logRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid log id"));

        return new LogResponseDto(log);
    }

    public Log updateChecked(Long id, Boolean checked) {
        Log log = logRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid log id"));

        log.setIsChecked(checked);

        return logRepository.save(log);
    }

}
