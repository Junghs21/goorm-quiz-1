package org.learning.goormquiz.lecture.application;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.learning.goormquiz.lecture.application.interfaces.MyLectureRepository;
import org.learning.goormquiz.lecture.repo.entity.Lectures;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MyLectureRepositoryImpl implements MyLectureRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Lectures findAllByMemberId(Long memberId) {
        return entityManager.createQuery("select l from LectureEntity l"
                        + " join fetch l.myLectures ml"
                        + " join fetch ml.member m"
                        + " where m.memberId=:memberId",
                        Lectures.class)
                .setParameter("memberId", memberId)
                .getSingleResult();
    }
}
