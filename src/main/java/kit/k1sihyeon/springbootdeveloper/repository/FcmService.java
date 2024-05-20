package kit.k1sihyeon.springbootdeveloper.repository;

import kit.k1sihyeon.springbootdeveloper.dto.FcmSendDto;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface FcmService {
    int sendMessageTo(FcmSendDto fcmSendDto) throws IOException;
}
