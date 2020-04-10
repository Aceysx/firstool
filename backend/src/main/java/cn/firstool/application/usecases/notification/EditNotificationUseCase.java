package cn.thoughtworks.school.application.usecases.notification;

import cn.thoughtworks.school.domain.context.core.exceptions.BusinessException;
import cn.thoughtworks.school.domain.context.notificationContext.Notification;
import cn.thoughtworks.school.domain.context.notificationContext.NotificationService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EditNotificationUseCase {
    private final NotificationService notificationService;
    private final Properties properties;
    private final NotificationFactory notificationFactory;

    public EditNotificationUseCase(NotificationService notificationService, Properties properties, NotificationFactory notificationFactory) {
        this.notificationService = notificationService;
        this.properties = properties;
        this.notificationFactory = notificationFactory;
    }

    public void changeStatus(String status, Long notificationId) throws BusinessException {
        notificationService.changeStatus(status, notificationId);
    }

    public void markAll(Long id, String status) {
        notificationService.markAll(id, status);
    }

    public List<Notification> addNotification(NotificationDto notificationDto) {
        NotificationFactory factory = notificationFactory.factory(notificationDto, properties);
        List<Notification> notifications = factory.getNotifications();
        return notificationService.addNotification(notifications);
    }
}
