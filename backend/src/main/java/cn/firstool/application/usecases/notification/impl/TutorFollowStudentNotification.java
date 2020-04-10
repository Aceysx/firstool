package cn.thoughtworks.school.application.usecases.notification.impl;

import cn.thoughtworks.school.adapter.inbound.rest.resources.user.UserDto;
import cn.thoughtworks.school.adapter.outbound.gateway.program.ProgramCenterService;
import cn.thoughtworks.school.application.usecases.notification.ProgramDto;
import cn.thoughtworks.school.adapter.outbound.gateway.user.UserCenterService;
import cn.thoughtworks.school.application.usecases.notification.NotificationDto;
import cn.thoughtworks.school.application.usecases.notification.NotificationFactory;
import cn.thoughtworks.school.application.usecases.notification.Properties;

import java.util.Objects;

public class TutorFollowStudentNotification extends NotificationFactory {

    public TutorFollowStudentNotification(NotificationDto data, Properties properties, UserCenterService userCenterService, ProgramCenterService programCenterService) {
        super(data, properties, userCenterService, programCenterService);
    }

    @Override
    protected String getMessage() {
        StringBuilder message = new StringBuilder();
        UserDto sender = getUser(Long.parseLong(data.getSenderId().toString()));
        ProgramDto program = getProgram();

        message.append(program.getTitle())
            .append(" 训练营的助教 ")
            .append(getUserName(sender))
            .append("关注了你!  ")
            .append(getContractInfo(sender));

        return message.toString();
    }

    @Override
    protected String getMessage_en() {
        StringBuilder message = new StringBuilder();
        UserDto sender = getUser(Long.parseLong(data.getSenderId().toString()));
        ProgramDto program = getProgram();

        message
            .append(" Tutor ")
            .append(getUserName(sender)).append("'s ")
            .append(program.getTitle())
            .append(" follow you.  ")
            .append(" His email is ").append(sender.getEmail());

        return message.toString();
    }

    private String getContractInfo(UserDto sender) {
        Object wechat = sender.getWechat();
        Object qq = sender.getQq();
        String result = " Ta 的Email是：" + sender.getEmail();
        if (!Objects.equals("", wechat) && Objects.nonNull(wechat)) {
            result += " 微信号是：" + wechat;
        }
        if (!Objects.equals("", qq) && Objects.nonNull(qq)) {
            result += " QQ号是：" + qq;
        }
        return result;
    }


}
