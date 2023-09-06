package com.whatever.ofi.repository;

import com.whatever.ofi.domain.CoordinatorProfile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CoordinatorProfileRepository {

    @PersistenceContext
    EntityManager em;

    public void save(CoordinatorProfile profile) {
        em.persist(profile);
    }
}
