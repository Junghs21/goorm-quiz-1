package org.learning.goormquiz.lecture.repo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.learning.goormquiz.member.repo.entity.MemberEntity;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "my_lecture")
public class MyLectureEntity {

    /**
     * lecture, member 연관관계
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    private LectureEntity lecture;
}
