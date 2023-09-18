package com.whatever.ofi.repository;

import com.whatever.ofi.domain.Board;
import com.whatever.ofi.domain.Coordinator;
import com.whatever.ofi.domain.User;
import com.whatever.ofi.responseDto.CoordinatorMyPageRes;
import com.whatever.ofi.responseDto.UserMainPageRes;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
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

    public List<String> findByEmail(String email) {
        return em.createQuery("select c.email from Coordinator c where c.email = :email ", String.class)
                .setParameter("email", email)
                .getResultList();
    }

    public Coordinator findByPassword(String email) {
        return em.createQuery("select c from Coordinator c where c.email = :email", Coordinator.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    public CoordinatorMyPageRes findMyPage(Long id) {
        Object[] result = em.createQuery(
                "select c.nickname, c.sns_url, c.image_url, c.content, " +
                        " c.height, c.weight, c.total_like, c.request_count, c.styles " +
                        " from Coordinator c " +
                        " where c.id = :id", Object[].class)
                .setParameter("id", id)
                .getSingleResult();

        return CoordinatorMyPageRes.builder()
                .nickname((String) result[0])
                .sns_url((String) result[1])
                .image_url((String) result[2])
                .content((String) result[3])
                .height((Integer) result[4])
                .weight((Integer) result[5])
                .total_like((Integer) result[6])
                .request_count((Integer) result[7])
                .styles((List<String>) result[8])
                .build();
    }

    public List<Board> findMainPage() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Board> cq = cb.createQuery(Board.class);

        Root<Board> b = cq.from(Board.class);

        Expression maxLike = cb.max(b.<Integer>get("like_count"));

        cq.groupBy(b.get("coordinator").get("id"));
        //cq.having(cb.equal(maxLike, b.get("like_count")));

        TypedQuery<Board> query = em.createQuery(cq);
        return query.getResultList();
//        return em.createQuery(
//                " select b from Board b " +
//                        " group by b.coordinator.id " +
//                        " having max(b.like_count) = b.like_count ", Board.class)
//                .getResultList();
    }
}
