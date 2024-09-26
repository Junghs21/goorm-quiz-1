package org.learning.goormquiz.lecture.application;

import lombok.RequiredArgsConstructor;
import org.learning.goormquiz.lecture.application.dto.response.GetLectureListResponseDto;
import org.learning.goormquiz.lecture.application.interfaces.MyLectureRepository;
import org.learning.goormquiz.lecture.repo.entity.Lectures;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyLectureService {

    private final MyLectureRepository myLectureRepository;

    /**
     * TODO
     * 내 강의 조회
     */
    public GetLectureListResponseDto getMyLectures(Long memberId) {
        Lectures lectures = myLectureRepository.findAllByMemberId(memberId);

        return GetLectureListResponseDto.from(lectures);
    }
}
