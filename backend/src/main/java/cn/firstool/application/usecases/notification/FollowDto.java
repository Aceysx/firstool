package cn.thoughtworks.school.application.usecases.notification;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FollowDto {
    private Long programId;
    private Long tutorId;
    private Long studentId;
}
