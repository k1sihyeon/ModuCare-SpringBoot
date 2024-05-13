package kit.k1sihyeon.springbootdeveloper.controller;

import kit.k1sihyeon.springbootdeveloper.domain.Camera;
import kit.k1sihyeon.springbootdeveloper.domain.Log;
import kit.k1sihyeon.springbootdeveloper.dto.AddLogRequest;
import kit.k1sihyeon.springbootdeveloper.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logs")
public class LogApiController {

    private final LogService logService;

    @Autowired
    public LogApiController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public ResponseEntity<Log> addLog(@RequestBody AddLogRequest request) {

        Log savedLog = logService.addLog(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedLog);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Log> getLog(@PathVariable Long id) {
        Log log = logService.getLog(id);

        Camera cam = log.getCamera();


        return ResponseEntity.ok(log);
    }


}
