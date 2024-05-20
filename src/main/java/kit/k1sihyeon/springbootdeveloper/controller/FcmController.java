package kit.k1sihyeon.springbootdeveloper.controller;

import kit.k1sihyeon.springbootdeveloper.dto.FcmSendDto;
import kit.k1sihyeon.springbootdeveloper.repository.FcmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

//FCM 관리 Controller
//모바일로부터 사용자 FCM 토큰, 메시지 제목, 내용을 받아서 서비스를 처리하는 Controller
@Slf4j
@RestController
@RequestMapping("/api/fcm")
public class FcmController {
    private final FcmService fcmService;

    public FcmController(FcmService fcmService) {
        this.fcmService = fcmService;
    }

    @PostMapping("/send")
    public ResponseEntity<Object> pushMessage(@RequestBody @Validated FcmSendDto fcmSendDto) throws IOException {
        log.debug("푸시 메시지 전송 요청");

        int result = fcmService.sendMessageTo(fcmSendDto);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
