package org.learning.goormquiz.lecture.repo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.learning.goormquiz.lecture.repo.entity.LectureEntity;
import org.learning.goormquiz.lecture.repo.jpa.JpaLectureRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaLectureService {

    private final JpaLectureRepository jpaLectureRepository;

    public LectureEntity findLecture(Long lectureId) {
        return jpaLectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("해당 강의를 찾을 수 없습니다."));
    }

    @Transactional
    public LectureEntity createLecture(LectureEntity lectureEntity) {
        return jpaLectureRepository.save(lectureEntity);
    }

    @Transactional
    public LectureEntity updateLecture(Long lectureId, LectureEntity lectureDetails) {
        LectureEntity lecture = findLecture(lectureId);
        lecture.updateTitle(lectureDetails.getTitle());

        return jpaLectureRepository.save(lecture);
    }

    @Transactional
    public void deleteLecture(Long lectureId) {
        LectureEntity lecture = findLecture(lectureId);
        jpaLectureRepository.delete(lecture);
    }
}
