package kit.k1sihyeon.springbootdeveloper.service;

import kit.k1sihyeon.springbootdeveloper.domain.Camera;
import kit.k1sihyeon.springbootdeveloper.dto.AddCameraRequest;
import kit.k1sihyeon.springbootdeveloper.repository.CameraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CameraService {
    private final CameraRepository cameraRepository;

    public Camera addCamera(AddCameraRequest request) {
        return cameraRepository.save(request.toEntity());
    }
}
