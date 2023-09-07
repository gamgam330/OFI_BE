package com.whatever.ofi.repository;

import com.whatever.ofi.domain.Coordinator;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
