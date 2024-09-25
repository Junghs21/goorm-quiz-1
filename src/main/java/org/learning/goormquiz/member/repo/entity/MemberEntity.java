package org.learning.goormquiz.member.repo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.learning.goormquiz.lecture.repo.entity.MyLectureEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "member")
public class MemberEntity {

    /**
     * TODO
     * member entity 생성
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    private String name;

    private String email;

    private String password;

    private String role;

    @OneToMany(mappedBy = "member")
    private List<MyLectureEntity> myLectures = new ArrayList<>();
}
