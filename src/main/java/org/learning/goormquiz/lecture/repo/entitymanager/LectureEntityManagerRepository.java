package org.learning.goormquiz.lecture.repo.entitymanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.learning.goormquiz.lecture.repo.entity.LectureEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class LectureEntityManagerRepository {

    @PersistenceContext
    private EntityManager em;

    /**
     * TODO
     * EntityManager를 이용해 db 조회
     */
    @Transactional
    public void createLecture(LectureEntity lecture) {
        if (lecture.getLectureId() == null) {
            em.persist(lecture);

            return;
        }
        em.merge(lecture);
    }

    public Optional<LectureEntity> findById(Long id) {
        return Optional.ofNullable(em.find(LectureEntity.class, id));
    }

    @Transactional
    public void deleteLecture(Long id) {
        LectureEntity lecture = em.find(LectureEntity.class, id);

        if (lecture != null) {
            em.remove(lecture);
        }
    }
}
