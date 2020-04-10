package cn.thoughtworks.school.application.usecases.notification.impl;

import cn.thoughtworks.school.adapter.inbound.rest.resources.user.UserDto;
import cn.thoughtworks.school.application.usecases.notification.AssignmentDto;
import cn.thoughtworks.school.adapter.outbound.gateway.program.ProgramCenterService;
import cn.thoughtworks.school.application.usecases.notification.ProgramDto;
import cn.thoughtworks.school.adapter.outbound.gateway.user.UserCenterService;
import cn.thoughtworks.school.application.usecases.notification.NotificationDto;
import cn.thoughtworks.school.application.usecases.notification.NotificationFactory;
import cn.thoughtworks.school.application.usecases.notification.Properties;

public class StudentModifyAssignmentNotification extends NotificationFactory {

    public StudentModifyAssignmentNotification(NotificationDto data, Properties properties, UserCenterService userCenterService, ProgramCenterService programCenterService) {
        super(data, properties, userCenterService, programCenterService);
        String tutorIds = getMyTutorIds();
        data.setReceiverId(tutorIds);
        data.setStudentId(data.getSenderId());
    }

    @Override
    protected String getMessage() {
        StringBuilder message = new StringBuilder();
        UserDto sender = getUser(Long.parseLong(data.getSenderId().toString()));
        ProgramDto program = getProgram();
        AssignmentDto assignment = getAssignment(data.getAssignmentId().toString());
        message.append(program.getTitle())
            .append(" 训练营的学员 ")
            .append(getUserName(sender))
            .append(" 完成了 ")
            .append(assignment.getTitle())
            .append(" 作业 ，快去看看吧！ ");

        return message.toString();
    }

    @Override
    protected String getMessage_en() {
        StringBuilder message = new StringBuilder();
        UserDto sender = getUser(Long.parseLong(data.getSenderId().toString()));
        ProgramDto program = getProgram();
        AssignmentDto assignment = getAssignment(data.getAssignmentId().toString());
        message.append(program.getTitle())
            .append(" : ")
            .append(getUserName(sender))
            .append(" finished ")
            .append(assignment.getTitle())
            .append(" assignment.");

        return message.toString();
    }
}
