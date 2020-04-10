package cn.thoughtworks.school.application.usecases.notification.impl;

import cn.thoughtworks.school.adapter.inbound.rest.resources.user.UserDto;
import cn.thoughtworks.school.adapter.outbound.gateway.program.ProgramCenterService;
import cn.thoughtworks.school.adapter.outbound.gateway.user.UserCenterService;
import cn.thoughtworks.school.application.usecases.notification.NotificationDto;
import cn.thoughtworks.school.application.usecases.notification.NotificationFactory;
import cn.thoughtworks.school.application.usecases.notification.Properties;

public class GrowthExcellentLogNotification extends NotificationFactory {

  public GrowthExcellentLogNotification(NotificationDto data, Properties properties, UserCenterService userCenterService, ProgramCenterService programCenterService) {

    super(data, properties, userCenterService, programCenterService);
  }

  @Override
  protected String getMessage() {
    StringBuilder message = new StringBuilder();
    UserDto sender = getUser(Long.parseLong(data.getSenderId().toString()));
    String diaryDate = data.getDiaryDate().toString();
    String username = data.getName();
    message.append(" 成长日志中用户 ")
      .append(getUserName(sender))
      .append(" 在优秀日志「")
      .append(username)
      .append(" - ")
      .append(diaryDate)
      .append("日」 的日志中评论了你! ");

    return message.toString();
  }

  @Override
  protected String getMessage_en() {
    StringBuilder message = new StringBuilder();
    UserDto sender = getUser(Long.parseLong(data.getSenderId().toString()));
    message.append(getUserName(sender))
      .append(" commented your diary.");

    return message.toString();
  }

}
