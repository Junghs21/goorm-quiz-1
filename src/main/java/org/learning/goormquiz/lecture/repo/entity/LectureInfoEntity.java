package org.learning.goormquiz.lecture.repo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
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

    public void updateTitle(String title) {
        this.title = title;
    }
}
