package kit.k1sihyeon.springbootdeveloper.controller;

import kit.k1sihyeon.springbootdeveloper.domain.Camera;
import kit.k1sihyeon.springbootdeveloper.domain.Log;
import kit.k1sihyeon.springbootdeveloper.dto.AddLogRequest;
import kit.k1sihyeon.springbootdeveloper.dto.CommentResponseDto;
import kit.k1sihyeon.springbootdeveloper.dto.LogResponseDto;
import kit.k1sihyeon.springbootdeveloper.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.LazyInitializationExcludeFilter;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogApiController {

    private final LogService logService;

    @Autowired
    public LogApiController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public ResponseEntity<LogResponseDto> addLog(@RequestBody AddLogRequest request) {
        Log savedLog = logService.addLog(request);
        LogResponseDto dto = new LogResponseDto(savedLog);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<LogResponseDto>> getLogList() {
        List<LogResponseDto> dtos = logService.findAll();
        dtos.sort((o1, o2) -> o2.getLogId().compareTo(o1.getLogId()));

        return ResponseEntity.ok(dtos);
    }

    @PatchMapping("/{id}/checked")
    public ResponseEntity<LogResponseDto> checkLog(@PathVariable Long id, @RequestBody Boolean checked) {
        Log checkedLog = logService.updateChecked(id, checked);
        LogResponseDto dto = new LogResponseDto(checkedLog);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogResponseDto> getLog(@PathVariable Long id) {
        LogResponseDto dto = logService.findById(id);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/unchecked")
    public ResponseEntity<List<LogResponseDto>> getUncheckedLogs() {
        List<LogResponseDto> dtos = logService.findUncheckedLogs();
        dtos.sort((o1, o2) -> o2.getLogId().compareTo(o1.getLogId()));

        return ResponseEntity.ok(dtos);
    }

}
