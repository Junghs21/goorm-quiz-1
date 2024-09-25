package org.learning.goormquiz.lecture.repo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.Getter;

import java.util.List;

@Getter
@Embeddable
public class LectureInfoEntity {

    /**
     * TODO
     * lecture info 생성
     */
    private String title;

    @Lob
    @Column(columnDefinition = "TEXT")
    @Convert(converter = LectureConverter.class)
    private List<String> goals;

    @Lob
    @Column(columnDefinition = "TEXT")
    @Convert(converter = LectureConverter.class)
    private List<String> target;
}
