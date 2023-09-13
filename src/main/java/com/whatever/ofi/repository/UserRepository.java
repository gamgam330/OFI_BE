package com.whatever.ofi.repository;

import com.whatever.ofi.domain.User;
import com.whatever.ofi.domain.UserProfile;
import com.whatever.ofi.domain.UserStyle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public void saveProfile(UserProfile userProfile) {
        em.persist(userProfile);
    }

    public void saveStyle(UserStyle userStyle) {
        em.persist(userStyle);
    }

    public User findOne(Long id) {
        return em.find(User.class, id);
    }
}
