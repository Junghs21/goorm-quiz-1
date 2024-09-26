package org.learning.goormquiz.lecture.repo.jpa;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.learning.goormquiz.lecture.repo.entity.LectureEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaLecutreRepository {

    private final EntityManager em;

    public List<LectureEntity> findAllByMemberId(Long memberId) {
        return em.createQuery(
                        "select l from LectureEntity l " +
                                "join fetch l.myLectures ml " +
                                "join fetch ml.member m " +
                                "where m.memberId = :memberId", LectureEntity.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }
}
