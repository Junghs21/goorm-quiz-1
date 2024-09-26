package org.learning.goormquiz.lecture.application;

import lombok.RequiredArgsConstructor;
import org.learning.goormquiz.common.domain.dto.CommonSuccessDto;
import org.learning.goormquiz.lecture.application.dto.request.CreateLectureRequestDto;
import org.learning.goormquiz.lecture.application.dto.request.UpdateLectureTitleRequestDto;
import org.learning.goormquiz.lecture.application.dto.response.GetLectureResponseDto;
import org.learning.goormquiz.lecture.application.interfaces.LectureRepository;
import org.learning.goormquiz.lecture.repo.entity.LectureEntity;
import org.learning.goormquiz.lecture.repo.entity.LectureInfoEntity;
import org.learning.goormquiz.lecture.repo.entity.PriceEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;

    /**
     * TODO
     * lectureRepository에서 데이터를 조회
     */
    public GetLectureResponseDto findLecture(Long lectureId) {
        LectureEntity lecture = lectureRepository.findById(lectureId);

        return GetLectureResponseDto.fromEntity(lecture);
    }

    /**
     * TODO
     * lectureRepository를 이용해 데이터를 생성
     */
    @Transactional
    public CommonSuccessDto createLecture(CreateLectureRequestDto dto) {
        LectureInfoEntity lectureInfo = new LectureInfoEntity(dto.title(), dto.goals(), dto.target());
        PriceEntity price = new PriceEntity(dto.price());
        LectureEntity lecture = new LectureEntity(null, lectureInfo, dto.instructor(), dto.imageUrl(),
                price, dto.lectureUrl());

        lectureRepository.save(lecture);

        return new CommonSuccessDto(true);
    }

    /**
     * TODO
     * lectureRepository를 이용해 데이터의 title 변경
     */
    @Transactional
    public CommonSuccessDto updateLecture(Long lectureId, UpdateLectureTitleRequestDto dto) {
        LectureEntity lecture = lectureRepository.findById(lectureId);
        lecture.updateTitle(dto.title());

        return new CommonSuccessDto(true);
    }

    /**
     * TODO
     * lectureRepository를 이용해 데이터 삭제
     */
    @Transactional
    public CommonSuccessDto deleteLecture(Long lectureId) {
        LectureEntity lecture = lectureRepository.findById(lectureId);
        lectureRepository.delete(lecture);

        return new CommonSuccessDto(true);
    }
}
