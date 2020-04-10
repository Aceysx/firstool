package cn.thoughtworks.school.application.usecases.notification;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AssignmentDto {
  private Long id;
  private Long taskId;
  private String type;
  private String title;
  private Long creatorId;
}