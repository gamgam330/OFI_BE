package com.whatever.ofi.controller;

import com.whatever.ofi.config.Util;
import com.whatever.ofi.domain.ChatRoom;
import com.whatever.ofi.repository.ChatRoomRepository;
import com.whatever.ofi.responseDto.MessagesResponse;
import com.whatever.ofi.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {
    @Value("${jwt.secret}")
    private String secretKey;
    private final ChatService chatService;
    private final Util util;

    //방만들기
    @PostMapping("/room")
    public String createRoom(@RequestParam String yournickname, @CookieValue("token") String token) {
        String mynickName = util.getNickname(token, secretKey);
        System.out.print(mynickName);
        return chatService.createChatRoom(mynickName, yournickname);
    }

    //읽음 처리 기능
    @GetMapping("/readChat")
    public void readMessage(Long chatid){
        chatService.readChat(chatid);
    }

    //message가져오기
    @GetMapping("/messages")
    public MessagesResponse getMessages(@CookieValue("token") String token, String roomid, String yournickname){
        String myNickname = util.getNickname(token, secretKey);
        return chatService.getMessages(myNickname, roomid, yournickname);
    }

    @GetMapping("/main")
    public List<ChatRoom> getChatRooms(@CookieValue("token") String token){
        String myNickname = util.getNickname(token, secretKey);
        return chatService.getChatingRooms(myNickname);
    }

    @GetMapping("/all")
    public List<ChatRoom> getAllRooms(){
        return chatService.getAllRooms();
    }

    @GetMapping("/find")
    public ChatRoom findRoom(String UUID){
        return chatService.findRoom(UUID);
    }
}
