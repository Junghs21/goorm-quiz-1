package org.learning.goormquiz.lecture.repo.jpa;

import org.learning.goormquiz.lecture.repo.entity.LectureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaMyLectureRepository extends JpaRepository<LectureEntity, Long> {

    @Query("select l from LectureEntity l"
            + " join fetch l.myLectures ml"
            + " join fetch ml.member m"
            + " where m.memberId=:memberId")
    List<LectureEntity> findAllByMemberId(@Param("memberId") Long memberId);
}
