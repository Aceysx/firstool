package cn.thoughtworks.school.adapter.outbound.persistence.notification;

import cn.thoughtworks.school.domain.context.core.exceptions.BusinessException;
import cn.thoughtworks.school.domain.context.notificationContext.Notification;
import cn.thoughtworks.school.domain.context.notificationContext.NotificationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class NotificationRepositoryImpl implements NotificationRepository {
    private final NotificationRepositoryVendor notificationRepositoryVendor;

    public NotificationRepositoryImpl(NotificationRepositoryVendor notificationRepositoryVendor) {
        this.notificationRepositoryVendor = notificationRepositoryVendor;
    }

    @Override
    public Notification findById(Long notificationId) throws BusinessException {
        return notificationRepositoryVendor.findById(notificationId)
            .map(NotificationPO::toDomain)
            .orElseThrow(() -> new BusinessException(
                String.format("current notification is not found with id %s", notificationId)
            ));
    }

    @Override
    public List<Notification> saveAll(List<Notification> notifications) {
        return notificationRepositoryVendor.saveAll(
            notifications.stream()
                .map(NotificationPO::of)
                .collect(Collectors.toList())
        )
            .stream()
            .map(NotificationPO::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public List<Notification> findAllByIsReadAndReceiverIdOrderByIdDesc(Boolean isRead, Long userId) {
        return notificationRepositoryVendor.findAllByIsReadAndReceiverIdOrderByIdDesc(isRead, userId)
            .stream()
            .map(NotificationPO::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public Page<Notification> findAllByIsReadAndReceiverId(Boolean isRead, Long userId, Pageable pageable) {
        Page<NotificationPO> notificationPOPage = notificationRepositoryVendor.findAllByIsReadAndReceiverId(isRead, userId, pageable);
        List<NotificationPO> content = notificationPOPage.getContent();
        List<Notification> newContent = content.stream()
            .map(NotificationPO::toDomain)
            .collect(Collectors.toList());
        return new PageImpl(newContent, pageable, notificationPOPage.getTotalElements());
    }

    @Override
    public void save(Notification notification) {
        notificationRepositoryVendor.save(NotificationPO.of(notification));
    }

    @Override
    public void updateByUserIdAndStatus(Long userId, Boolean isRead) {
        notificationRepositoryVendor.updateByUserIdAndStatus(userId, isRead);
    }
}
