package cn.thoughtworks.school.adapter.outbound.persistence.notification;

import cn.thoughtworks.school.domain.context.notificationContext.Notification;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hankcs.hanlp.HanLP;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "notification")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class NotificationPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public static Notification toDomain(NotificationPO notificationPO) {
        return Notification.builder()
            .id(notificationPO.id)
            .senderId(notificationPO.senderId)
            .receiverId(notificationPO.receiverId)
            .isRead(notificationPO.isRead)
            .message(notificationPO.message)
            .message_en(notificationPO.message_en)
            .url(notificationPO.url)
            .createTime(notificationPO.createTime)
            .type(notificationPO.type)
            .build();
    }

    public static NotificationPO of(Notification notification) {
        return NotificationPO.builder()
            .id(notification.getId())
            .senderId(notification.getSenderId())
            .receiverId(notification.getReceiverId())
            .isRead(notification.getIsRead())
            .message(notification.getMessage())
            .message_en(notification.getMessage_en())
            .url(notification.getUrl())
            .createTime(notification.getCreateTime())
            .type(notification.getType())
            .build();
    }
}
