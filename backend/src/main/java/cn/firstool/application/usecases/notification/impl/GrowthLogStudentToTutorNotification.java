package cn.thoughtworks.school.application.usecases.notification.impl;

import cn.thoughtworks.school.adapter.inbound.rest.resources.user.UserDto;
import cn.thoughtworks.school.adapter.outbound.gateway.program.ProgramCenterService;
import cn.thoughtworks.school.adapter.outbound.gateway.user.UserCenterService;
import cn.thoughtworks.school.application.usecases.notification.NotificationDto;
import cn.thoughtworks.school.application.usecases.notification.NotificationFactory;
import cn.thoughtworks.school.application.usecases.notification.Properties;

public class GrowthLogStudentToTutorNotification extends NotificationFactory {

    public GrowthLogStudentToTutorNotification(NotificationDto data, Properties properties, UserCenterService userCenterService, ProgramCenterService programCenterService) {

        super(data, properties, userCenterService, programCenterService);
    }

    @Override
    protected String getMessage() {
        StringBuilder message = new StringBuilder();
        UserDto sender = getUser(Long.parseLong(data.getSenderId().toString()));
        String diaryDate = data.getDiaryDate().toString();
        message.append(" 成长日志中用户 ")
            .append(getUserName(sender))
            .append(" 在「")
            .append(diaryDate)
            .append("日」的日志中回复了你! ");

        return message.toString();
    }

    @Override
    protected String getMessage_en() {
        StringBuilder message = new StringBuilder();
        UserDto sender = getUser(Long.parseLong(data.getSenderId().toString()));
        message.append(getUserName(sender))
            .append(" replied you message.");
        return message.toString();
    }
}
