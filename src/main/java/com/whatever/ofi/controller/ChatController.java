package com.whatever.ofi.controller;


import com.whatever.ofi.requestDto.ChatMessage;
import com.whatever.ofi.responseDto.SendChatMessage;
import com.whatever.ofi.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Slf4j
@RequiredArgsConstructor
@Controller
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatService chatService;

    /**
     * websocket "/pub/chat/message"로 들어오는 메시징을 처리한다.
     */
    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        Long chatId = chatService.saveMessage(message);
        messagingTemplate.convertAndSend( "/sub/chatroom/"+ message.getRoomId(), SendChatMessage.of(chatId, message));
    }
}