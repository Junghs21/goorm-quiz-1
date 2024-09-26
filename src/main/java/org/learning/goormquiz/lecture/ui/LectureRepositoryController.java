package org.learning.goormquiz.lecture.ui;

import lombok.RequiredArgsConstructor;
import org.learning.goormquiz.lecture.repo.entity.LectureEntity;
import org.learning.goormquiz.lecture.repo.entity.Lectures;
import org.learning.goormquiz.lecture.repo.jpa.JpaLecutreRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class LectureRepositoryController {

    private final JpaLecutreRepository jpaLecutreRepository;

    @GetMapping("/api/{memberId}")
    public Lectures findAllByMemberId(@PathVariable Long memberId) {
        List<LectureEntity> entityList = jpaLecutreRepository.findAllByMemberId(memberId);

        List<LectureEntity> result = entityList.stream()
                .map(LectureEntity::toLectureDto)
                .collect(Collectors.toList());

        return new Lectures(result);
    }
}
