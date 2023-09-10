package com.whatever.ofi.repository;

import com.whatever.ofi.domain.Board;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BoardRepository {
    @PersistenceContext
    EntityManager em;

    public Board findOne(Long id) {
       return em.find(Board.class, id);
    }

    public void save(Board board) {
        em.persist(board);
    }


}
