package cn.thoughtworks.school.domain.context.notificationContext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hankcs.hanlp.HanLP;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class Notification {
    private Long id;
    private Long senderId;
    private Long receiverId;
    private Boolean isRead;
    private String message;
    private String message_en;
    private String url;
    private String createTime;
    private String type;

    @JsonProperty("message_zh_TW")
    public String getMessageTW() {
        return Objects.isNull(message) ? "" : HanLP.s2tw(message);
    }
}
