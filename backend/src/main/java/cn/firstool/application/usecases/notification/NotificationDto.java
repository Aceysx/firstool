package cn.thoughtworks.school.application.usecases.notification;

import lombok.Data;

import java.util.Date;

@Data
public class NotificationDto {
    private Long senderId;
    private String receiverId;
    private Long followees;
    private String type;
    private String appType;

    private Date diaryDate;
    private String name;

    private Long programId;
    private Long taskId;
    private Long assignmentId;
    private Long quizId;
    private Long studentId;
}
