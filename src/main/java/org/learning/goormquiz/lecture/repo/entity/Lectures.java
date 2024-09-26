package org.learning.goormquiz.lecture.repo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Lectures {

    private List<LectureEntity> lectures;
}
