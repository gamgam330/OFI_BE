package com.whatever.ofi.repository;

import com.whatever.ofi.domain.Board;
import com.whatever.ofi.domain.Coordinator;
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

//    public void saveStyle(CoordinatorStyle coordinatorStyle) {
//        em.persist(coordinatorStyle);
//    }

//    public List<String> findStyle(Long id) {
//        return em.createQuery("select c.style from CoordinatorStyle c where id =: id", String.class)
//                .setParameter("id", id)
//                .getResultList();
//    }
    public List<UserMainPageRes> findPopularCoordinator() {
        List<Object[]> resultList = em.createQuery(
                " select c.nickname, c.image_url, b.image_url, c.total_like, c.request_count, c.styles " +
                        " from Board b, Coordinator c " +
                        " where b.coordinator.id = c.id " +
                        " group by c.id " , Object[].class)
                .setMaxResults(20)
                .getResultList();

        List<UserMainPageRes> dtos = new ArrayList<>();

        for (Object[] result : resultList) {
            UserMainPageRes dto = new UserMainPageRes();

            dto.setNickname((String) result[0]);
            dto.setProfile_image((String) result[1]);
            dto.setBoard_image((String) result[2]);
            dto.setTotal_like((Integer) result[3]);
            dto.setRequest_count((Integer) result[4]);
            dto.setStyles((List<String>) result[5]);
            dtos.add(dto);
        }

        return dtos;
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
//
//    public List<QueryDto> findPages() {
//        return em.createQuery(
//                "select c.nickname, c.image_url, b.image_url, c.total_like, c.request_count " +
//                        "from CoordinatorProfile c " +
//                        "INNER JOIN c.coordinator.boards b " +
//                        "where c.id = b.coordinator.id " +
//                        "group by c.id " +
//                        "having max(b.like_count) " +
//                        "order by c.id asc", QueryDto.class)
//                .getResultList();
//    }
}
