package com.whatever.ofi.controller;

import com.whatever.ofi.config.Util;
import com.whatever.ofi.repository.ChatRoomRepository;
import com.whatever.ofi.requestDto.ChatMessage;
import com.whatever.ofi.responseDto.SendChatMessage;
import com.whatever.ofi.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ChatController {

    private final ChatService chatService;
    private final RedisTemplate redisTemplate;
    private final ChannelTopic channelTopic;

    /**
     * websocket "/pub/chat/message"로 들어오는 메시징을 처리한다.
     */
    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        redisTemplate.convertAndSend( channelTopic.getTopic(), message);
    }
}