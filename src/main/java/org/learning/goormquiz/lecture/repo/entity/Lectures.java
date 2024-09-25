package org.learning.goormquiz.lecture.repo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class Lectures {

    private List<LectureEntity> lectures;
}
