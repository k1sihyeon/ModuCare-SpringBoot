package kit.k1sihyeon.springbootdeveloper.controller;

import kit.k1sihyeon.springbootdeveloper.domain.Camera;
import kit.k1sihyeon.springbootdeveloper.dto.AddCameraRequest;
import kit.k1sihyeon.springbootdeveloper.service.CameraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CameraApiController {

    private final CameraService cameraService;

    @RequestMapping("/api/cameras")
    public ResponseEntity<Camera> addCamera(@RequestBody AddCameraRequest request) {
        Camera savedCamera = cameraService.addCamera(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCamera);
    }
}
