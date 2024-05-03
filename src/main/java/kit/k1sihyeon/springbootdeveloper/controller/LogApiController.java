package kit.k1sihyeon.springbootdeveloper.controller;

import kit.k1sihyeon.springbootdeveloper.domain.Log;
import kit.k1sihyeon.springbootdeveloper.dto.AddLogRequest;
import kit.k1sihyeon.springbootdeveloper.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LogApiController {

    private final LogService logService;

    @RequestMapping("/api/logs")
    public ResponseEntity<Log> addLog(@RequestBody AddLogRequest request) {

        Log savedLog = logService.addLog(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedLog);
    }
}
