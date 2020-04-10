package cn.thoughtworks.school.domain.context.notificationContext;

import cn.thoughtworks.school.domain.context.core.exceptions.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NotificationService {
    public static final String STATUS_READ = "read";
    public static final String STATUS_UN_READ = "unRead";

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }
    public List<Notification> addNotification(List<Notification> notifications) {
        return notificationRepository.saveAll(notifications);
    }


    public List<Notification> getUnreadNotifications(Long userId, String status) {
        Boolean isRead = (STATUS_READ).equals(status);
        return notificationRepository.findAllByIsReadAndReceiverIdOrderByIdDesc(isRead, userId);
    }

    public Page<Notification> getReadNotifications(Long userId, String status, Pageable pageable) {
        Boolean isRead = (STATUS_READ).equals(status);
        return notificationRepository.findAllByIsReadAndReceiverId(isRead, userId, pageable);
    }

    public void changeStatus(String status, Long notificationId) throws BusinessException {
        Notification notification = findById(notificationId);
        boolean needToUpdate = STATUS_UN_READ.equals(status);
        notification.setIsRead(needToUpdate);
        notificationRepository.save(notification);
    }

    public void markAll(Long userId, String status) {
        Boolean isRead = (STATUS_READ).equals(status);
        notificationRepository.updateByUserIdAndStatus(userId, isRead);
    }

    public Notification findById(Long notificationId) throws BusinessException {
        return notificationRepository.findById(notificationId);
    }
}
