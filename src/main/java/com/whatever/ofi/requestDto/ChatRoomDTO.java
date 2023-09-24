package com.whatever.ofi.requestDto;

import com.whatever.ofi.domain.ChatHistory;
import com.whatever.ofi.domain.Coordinator;
import com.whatever.ofi.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ChatRoomDTO {
    private Long id;
    private String roomId;
    private User fiter;
    private Coordinator outer;
    private List<ChatHistory> histories;


}