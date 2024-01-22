package com.store.onedaySeed.entity;

import com.store.onedaySeed.constant.LessonStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="lesson")
@Getter
@Setter
@ToString
public class Lesson extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lesson_id")
    private Long lessonId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_num")
    private Host host;

    @Column(nullable = false, name ="lesson_name")
    private String lessonName;

    @Column(nullable = false,  name ="lesson_category")
    private String lessonCategory;

    @Column(nullable = false , name="lesson_schedule")
    private String lessonSchedule;
    //LocalDateTime,Long ?

    @Column(nullable = false, name ="fee")
    private Long price;

    @Column(nullable = false , name ="lesson_limited")
    private Integer lessonLimited; //인원수 제한

    @Enumerated(EnumType.STRING)
    private LessonStatus lessonStatus;

    







}
