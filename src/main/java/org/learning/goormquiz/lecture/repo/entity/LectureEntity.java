package org.learning.goormquiz.lecture.repo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    public LectureEntity(Long lectureId, LectureInfoEntity lectureInfo, String instructor, String imageUrl, PriceEntity price, String lectureUrl) {
        this.lectureId = lectureId;
        this.lectureInfo = lectureInfo;
        this.instructor = instructor;
        this.imageUrl = imageUrl;
        this.price = price;
        this.lectureUrl = lectureUrl;
    }

    public int getPrice() {
        return price.getPrice();
    }

    public String getTitle() {
        return lectureInfo.getTitle();
    }

    public List<String> getGoals() {
        return lectureInfo.getGoals();
    }

    public List<String> getTarget() {
        return lectureInfo.getTarget();
    }

    public void updateTitle(String title) {
        this.lectureInfo.updateTitle(title);
    }

    public LectureEntity toLectureDto() {
        return new LectureEntity(lectureId,
                new LectureInfoEntity(getTitle(), getGoals(), getTarget()),
                instructor, imageUrl,
                new PriceEntity(getPrice()),
                lectureUrl);
    }
}
