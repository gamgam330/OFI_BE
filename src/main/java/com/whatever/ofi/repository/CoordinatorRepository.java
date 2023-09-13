package com.whatever.ofi.repository;

import com.whatever.ofi.domain.Coordinator;
import com.whatever.ofi.domain.CoordinatorStyle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CoordinatorRepository {
    @PersistenceContext
    EntityManager em;

    public void save(Coordinator coordinator) {
        em.persist(coordinator);
    }

    public Coordinator findOne(Long id) {
        return em.find(Coordinator.class, id);
    }

    public void saveStyle(CoordinatorStyle coordinatorStyle) {
        em.persist(coordinatorStyle);
    }
}
