package com.example.demo.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import com.example.demo.model.dto.Notification;
import com.example.demo.model.dto.SeatMessage;

@Component // [12주차] 단계 3 & 4 : 트랜잭션이 커밋된 뒤에 실시간 메시지를 보낸다
public class RealtimeNotifier {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @TransactionalEventListener // 기본 = AFTER_COMMIT : 커밋이 성공했을 때만 전송 (롤백되면 보내지 않는다)
    public void sendSeats(SeatMessage message) {
        messagingTemplate.convertAndSend("/topic/seats", message); // 구독한 모든 브라우저로
    }

    @TransactionalEventListener // 단계 4 : 개인 알림도 커밋 뒤에 전송
    public void sendNotification(Notification notification) {
        messagingTemplate.convertAndSendToUser(notification.to(), "/queue/notifications", notification); // 해당 아이디 사용자에게만
    }
}