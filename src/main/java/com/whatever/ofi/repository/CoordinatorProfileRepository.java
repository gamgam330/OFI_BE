package com.whatever.ofi.repository;

import com.whatever.ofi.domain.CoordinatorProfile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CoordinatorProfileRepository {

    @PersistenceContext
    EntityManager em;

    public void save(CoordinatorProfile profile) {
        em.persist(profile);
    }

    public List<String> findByNickname(String nickname) {
        return em.createQuery("select c.nickname from CoordinatorProfile c where c.nickname = :nickname", String.class)
                .setParameter("nickname", nickname)
                .getResultList();
    }
}
