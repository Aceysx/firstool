package cn.thoughtworks.school.application.usecases.notification;

import cn.thoughtworks.school.domain.context.notificationContext.Notification;
import cn.thoughtworks.school.domain.context.notificationContext.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryNotificationUseCase {
    private final NotificationService notificationService;

    public QueryNotificationUseCase(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public Page<Notification> getReadNotifications(Long userId, String status, Pageable pageable) {
        return notificationService.getReadNotifications(userId, status, pageable);
    }

    public List<Notification> getUnreadNotifications(Long userId, String status) {
        return notificationService.getUnreadNotifications(userId, status);
    }
}
