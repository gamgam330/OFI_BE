package com.whatever.ofi.repository;

import com.whatever.ofi.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public User findOne(Long id) {
        return em.find(User.class, id);
    }


    public String findByEmail(String email) {
        return em.createQuery("select u.email from User u where u.email = :email", String.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    public User findByPassword(String email) {
        return em.createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
    }
}
