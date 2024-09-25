package org.learning.goormquiz.lecture.repo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "lecture")
public class LectureEntity {

    /**
     * TODO
     * lecture entity 생성
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long lectureId;

    @Embedded
    private LectureInfoEntity lectureInfo;

    private String imageUrl;

    private String instructor;

    @Embedded
    private PriceEntity price;

    private String lectureUrl;

    @OneToMany(mappedBy = "lecture")
    private List<MyLectureEntity> myLectures = new ArrayList<>();
}
