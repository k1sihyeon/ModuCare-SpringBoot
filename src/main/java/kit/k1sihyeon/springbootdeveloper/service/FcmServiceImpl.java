package kit.k1sihyeon.springbootdeveloper.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import kit.k1sihyeon.springbootdeveloper.dto.FcmMessageDto;
import kit.k1sihyeon.springbootdeveloper.dto.FcmSendDto;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.io.IOException;
import java.util.List;

//FCM 서비스를 처리하는 구현체
@Service
public class FcmServiceImpl implements FcmService {

    //푸시 메시지 처리를 수행하는 비즈니스 로직
    //fcmSendDto: 모바일에서 전달받은 Object
    @Override
    public int sendMessageTo(FcmSendDto fcmSendDto) throws IOException {
        String message = makeMessage(fcmSendDto);
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + getAccessToken());

        HttpEntity entity = new HttpEntity<>(message, headers);

        String API_URL = "https://fcm.googleapis.com/v1/projects/moducare/messages:send";
        ResponseEntity response = restTemplate.exchange(API_URL, HttpMethod.POST, entity, String.class);

        System.out.println(response.getStatusCode());

        return response.getStatusCode() == HttpStatus.OK ? 1 : 0;
    }

    //Firebase Admin SDK의 비공개 키를 참조하여 Bearer 토큰을 발급
    private String getAccessToken() throws IOException {
        String firebaseConfigPath = "firebase/moducare-firebase-adminsdk-e77z4-957deb46b8.json";

        GoogleCredentials googleCredentials = GoogleCredentials
                .fromStream(new ClassPathResource(firebaseConfigPath).getInputStream())
                .createScoped(List.of("<https://www.googleapis.com/auth/cloud-platform>"));

        googleCredentials.refreshIfExpired();
        return googleCredentials.getAccessToken().getTokenValue();
    }

    //FCM 전송 정보를 기반으로 메시지를 구성합니다. (Object -> String)
    private String makeMessage(FcmSendDto fcmSendDto) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        FcmMessageDto fcmMessageDto = FcmMessageDto.builder()
                .message(FcmMessageDto.Message.builder()
                        .token(fcmSendDto.getToken())
                        .notification(FcmMessageDto.Notification.builder()
                                .title(fcmSendDto.getTitle())
                                .body(fcmSendDto.getBody())
                                .image(null)
                                .build()
                        ).build()).validateOnly(false).build();

        return om.writeValueAsString(fcmMessageDto);
    }
}
