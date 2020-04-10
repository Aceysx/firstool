package cn.thoughtworks.school.application.usecases.notification;

import cn.thoughtworks.school.adapter.inbound.rest.resources.user.UserDto;
import cn.thoughtworks.school.adapter.outbound.gateway.program.ProgramCenterService;
import cn.thoughtworks.school.adapter.outbound.gateway.user.UserCenterService;
import cn.thoughtworks.school.application.usecases.notification.impl.*;
import cn.thoughtworks.school.domain.context.notificationContext.Notification;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
public class NotificationFactory {
    private UserCenterService userCenterService;
    protected ProgramCenterService programCenterService;

    private String CURRENT_NOTIFICATION_TYPE;
    protected NotificationDto data;
    private Map<String, String> properties;

    public NotificationFactory() {
    }

    public NotificationFactory(NotificationDto data, Properties properties, UserCenterService userCenterService, ProgramCenterService programCenterService) {
        this.CURRENT_NOTIFICATION_TYPE = data.getType();
        this.data = data;
        this.properties = properties.getNotifications();
        this.userCenterService = userCenterService;
        this.programCenterService = programCenterService;
    }

    @Autowired
    public NotificationFactory(UserCenterService userCenterService, ProgramCenterService programCenterService) {
        this.userCenterService = userCenterService;
        this.programCenterService = programCenterService;
    }

    public NotificationFactory factory(NotificationDto data, Properties props) {
        String type = data.getType();
        switch (type) {
            case "TUTOR_FOLLOW_STUDENT":
                return new TutorFollowStudentNotification(data, props, userCenterService, programCenterService);
            case "TUTOR_MODIFY_ASSIGNMENT_STATUS":
                return new TutorModifyAssignmentNotification(data, props, userCenterService, programCenterService);
            case "TUTOR_COMMENT_ASSIGNMENT":
                return new TutorCommentAssignmentNotification(data, props, userCenterService, programCenterService);
            case "STUDENT_MODIFY_ASSIGNMENT_STATUS":
                return new StudentModifyAssignmentNotification(data, props, userCenterService, programCenterService);
            case "STUDENT_COMMENT_ASSIGNMENT":
                return new StudentCommentAssignmentNotification(data, props, userCenterService, programCenterService);
            case "GROWTH_NOTE_STUDENT_TO_TUTOR":
                return new GrowthLogStudentToTutorNotification(data, props, userCenterService, programCenterService);
            case "GROWTH_NOTE_TUTOR_TO_STUDENT":
                return new GrowthLogTutorToStudentNotification(data, props, userCenterService, programCenterService);
            case "GROWTH_EXCELLENT_NOTE":
                return new GrowthExcellentLogNotification(data, props, userCenterService, programCenterService);
        }
        return null;
    }

    protected String getMessage() {
        return "";
    }

    protected String getMessage_en() {
        return "";
    }

    private String getUrl() {
        String url = properties.get(CURRENT_NOTIFICATION_TYPE);
        Map values = new ObjectMapper().convertValue(data, Map.class);
        log.info("all url:" + properties);
        for (Object key : values.keySet()) {
            url = url.replace(":" + key, values.get(key).toString());
        }
        log.info("current url" + url);
        return url;
    }

    public List<Notification> getNotifications() {
        if ("".equals(data.getReceiverId())) {
            return new ArrayList<>();
        }
        List<String> receiverIds = Arrays.asList(data.getReceiverId().split(","));
        return receiverIds.stream().map(receiverId -> Notification.builder()
            .receiverId(Long.parseLong(receiverId))
            .senderId(Long.parseLong(data.getSenderId().toString()))
            .message(getMessage())
            .message_en(getMessage_en())
            .isRead(false)
            .type(CURRENT_NOTIFICATION_TYPE)
            .createTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
            .url(getUrl()).build()
        ).collect(Collectors.toList());

    }

    protected ProgramDto getProgram() {
        Long programId = Long.parseLong(data.getProgramId().toString());
        return programCenterService.getProgramById(programId);
    }

    protected UserDto getUser(Long id) {
        return userCenterService.getUserInfo(id);
    }

    protected String getUserName(UserDto user) {
        if (Objects.nonNull(user.getName())) {
            return user.getName();
        }
        return user.getUserName();
    }

    protected AssignmentDto getAssignment(String assignmentId) {
        return programCenterService.getAssignment(assignmentId);
    }

    protected String getMyTutorIds() {
        List<FollowDto> tutors = programCenterService.getMyTutors(Long.parseLong(data.getProgramId().toString()), Long.parseLong(data.getSenderId().toString()));
        return tutors.stream()
            .map(item -> item.getTutorId().toString())
            .collect(Collectors.joining(","));
    }
}
