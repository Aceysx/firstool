package cn.thoughtworks.school.adapter.outbound.persistence.notification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NotificationRepositoryVendor extends JpaRepository<NotificationPO, Long> {

  List<NotificationPO> findAllByIsReadAndReceiverIdOrderByIdDesc(Boolean isRead, Long userId);

  @Modifying
  @Transactional
  @Query("update NotificationPO n set isRead=?2 where n.receiverId=?1")
  void updateByUserIdAndStatus(Long userId, Boolean status);

  Page<NotificationPO> findAllByIsReadAndReceiverId(Boolean isRead, Long userId, Pageable pageable);
}
