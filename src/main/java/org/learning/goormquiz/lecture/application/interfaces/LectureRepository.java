package org.learning.goormquiz.lecture.application.interfaces;

import org.learning.goormquiz.lecture.repo.entity.LectureEntity;

public interface LectureRepository {

    void save(LectureEntity lecture);

    void delete(LectureEntity lecture);

    LectureEntity findById(Long id);
}
