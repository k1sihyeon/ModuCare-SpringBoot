package kit.k1sihyeon.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

//FCM 전송 Format DTO
//FCM에 실제 전송될 데이터의 DTO

@Getter
@Builder
public class FcmMessageDto {
    private boolean validateOnly;
    private FcmMessageDto.Message message;

    @Builder
    @AllArgsConstructor
    @Getter
    public static class Message {
        private FcmMessageDto.Notification notification;
        private String token;
    }

    @Builder
    @AllArgsConstructor
    @Getter
    public static class Notification {
        private String title;
        private String body;
        private String image;
    }
}

/*

{
   "message":{
      "token":"asdf...",
      "notification":{
        "body":"This is an FCM notification message!",
        "title":"FCM Message"
      }
   }
}

*/