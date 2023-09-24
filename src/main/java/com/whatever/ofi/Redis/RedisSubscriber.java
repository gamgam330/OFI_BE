package com.whatever.ofi.Redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatever.ofi.requestDto.ChatMessage;
import com.whatever.ofi.responseDto.SendChatMessage;
import com.whatever.ofi.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RedisSubscriber {

    private final ObjectMapper objectMapper;
    private final SimpMessageSendingOperations messagingTemplate;
    private final ChatService chatService;

    /**
     * Redis에서 메시지가 발행(publish)되면 대기하고 있던 Redis Subscriber가 해당 메시지를 받아 처리한다.
     */
    public void sendMessage(String publishMessage) {
        try {
            // ChatMessage 객채로 맵핑
            ChatMessage message = objectMapper.readValue(publishMessage, ChatMessage.class);
            Long chatId = chatService.saveMessage(message);
            // 채팅방을 구독한 클라이언트에게 메시지 발송
            messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), SendChatMessage.of(chatId, message));
        } catch (Exception e) {
            log.error("Exception {}", e);
        }
    }
}