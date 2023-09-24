package com.whatever.ofi.repository;

import com.whatever.ofi.domain.ChatRoom;
import com.whatever.ofi.domain.Coordinator;
import com.whatever.ofi.domain.User;
import com.whatever.ofi.requestDto.ChatRoomDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Repository
public class ChatRoomRepository {
    @PersistenceContext
    EntityManager em;

    public void save(ChatRoom chatRoom){
        //이거 ChatRoom도 Entity로 만들어서 저장해야됨.
        em.persist(chatRoom);
    }

    public ChatRoom findChatRoomByRoomId(String roomId){
        return em.createQuery(" select c from ChatRoom c where c.roomId = :roomId ", ChatRoom.class)
                .setParameter("roomId", roomId)
                .getSingleResult();
    }

    public ChatRoom findChatRoomByUsers(User fiter, Coordinator outer) {
        List<ChatRoom> resultList = em.createQuery("SELECT c FROM ChatRoom c WHERE c.fiter = :fiter AND c.outer = :outer", ChatRoom.class)
                .setParameter("fiter", fiter)
                .setParameter("outer", outer)
                .getResultList();

        return resultList.isEmpty() ? null : resultList.get(0);
    }

    public List<ChatRoomDTO> findChatRoomsByUser(User user) {
        List<ChatRoom> chatRooms = em.createQuery("SELECT c FROM ChatRoom c WHERE c.fiter = :user", ChatRoom.class)
                .setParameter("user", user)
                .getResultList();

        return chatRooms.stream()
                .map(ChatRoom::toDTO)
                .collect(Collectors.toList());
    }


    public List<ChatRoomDTO> findChatRoomsByCoordinator(Coordinator coordinator) {
        List<ChatRoom> chatRooms = em.createQuery("SELECT c FROM ChatRoom c WHERE c.outer = :coordinator", ChatRoom.class)
                .setParameter("coordinator", coordinator)
                .getResultList();

        return chatRooms.stream()
                .map(ChatRoom::toDTO)
                .collect(Collectors.toList());
    }


    public List<ChatRoom> findAllRooms(){
        return em.createQuery("select c FROM ChatRoom c", ChatRoom.class)
                .getResultList();
    }
}