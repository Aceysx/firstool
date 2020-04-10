package cn.thoughtworks.school.application.usecases.notification;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ProgramDto {
    private Long id;
    private String title;
    private Long creatorId;
    private Long organizationId;

}
