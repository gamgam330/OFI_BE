package com.whatever.ofi.repository;

import com.whatever.ofi.responseDto.CoordinatorMainPageRes;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MainPageRepository {
    @PersistenceContext
    EntityManager em;

    public List<CoordinatorMainPageRes> findPopularCoordinator() {
        List<Object[]> resultList = em.createQuery(
                        " select c.nickname, c.image_url, c.total_like, c.request_count, c.styles " +
                                " from Board b, Coordinator c " +
                                " where b.coordinator.id = c.id " +
                                " group by c.id " , Object[].class)
                .setMaxResults(20)
                .getResultList();

        List<CoordinatorMainPageRes> dtos = new ArrayList<>();

        for (Object[] result : resultList) {
            CoordinatorMainPageRes dto = new CoordinatorMainPageRes();

            dto.setNickname((String) result[0]);
            dto.setProfile_image((String) result[1]);
            dto.setTotal_like((Integer) result[2]);
            dto.setRequest_count((Integer) result[3]);
            dto.setStyles((List<String>) result[4]);
            dtos.add(dto);
        }

        return dtos;
    }
}
