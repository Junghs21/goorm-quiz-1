package org.learning.goormquiz.lecture.application;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.learning.goormquiz.lecture.application.interfaces.LectureRepository;
import org.learning.goormquiz.lecture.repo.entity.LectureEntity;
import org.springframework.stereotype.Repository;

@Repository
public class LectureRepositoryImpl implements LectureRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(LectureEntity lecture) {
        if (lecture.getLectureId() == null) {
            entityManager.persist(lecture);
        } else {
            entityManager.merge(lecture);
        }
    }

    @Override
    @Transactional
    public void delete(LectureEntity lecture) {
        entityManager.remove(entityManager.contains(lecture) ? lecture : entityManager.merge(lecture));
    }

    @Override
    public LectureEntity findById(Long id) {
        return entityManager.find(LectureEntity.class, id);
    }
}