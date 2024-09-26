package org.learning.goormquiz.lecture.repo;

import lombok.RequiredArgsConstructor;
import org.learning.goormquiz.lecture.repo.entity.LectureEntity;
import org.learning.goormquiz.lecture.repo.entity.Lectures;
import org.learning.goormquiz.lecture.repo.jpa.JpaMyLectureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JpaMyLectureService {

    private final JpaMyLectureRepository jpaMyLectureRepository;

    @Transactional(readOnly = true)
    public Lectures getMyLectures(Long memberId) {
        List<LectureEntity> lectureEntities = jpaMyLectureRepository.findAllByMemberId(memberId);

        return new Lectures(lectureEntities);
    }
}
