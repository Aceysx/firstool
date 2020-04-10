package cn.thoughtworks.school.domain.context.notificationContext;

import cn.thoughtworks.school.domain.context.core.exceptions.BusinessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NotificationRepository {

    Notification findById(Long notificationId) throws BusinessException;

    List<Notification> saveAll(List<Notification> notifications);

    List<Notification> findAllByIsReadAndReceiverIdOrderByIdDesc(Boolean isRead, Long userId);

    Page<Notification> findAllByIsReadAndReceiverId(Boolean isRead, Long userId, Pageable pageable);

    void save(Notification notification);

    void updateByUserIdAndStatus(Long userId, Boolean isRead);
}
