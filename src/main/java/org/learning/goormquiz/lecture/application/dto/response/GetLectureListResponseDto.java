package org.learning.goormquiz.lecture.application.dto.response;

import org.learning.goormquiz.lecture.repo.entity.Lectures;

import java.util.List;

public record GetLectureListResponseDto(List<GetLectureResponseDto> dtos) {

    public static GetLectureListResponseDto from(Lectures lectures) {
        return new GetLectureListResponseDto(lectures.
            getLectures().stream().map(GetLectureResponseDto::fromEntity).toList());
    }
}
