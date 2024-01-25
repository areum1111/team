package com.store.onedaySeed.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LessonDto {

    private Long lessonId;
    private String lessonName;
    private String lessonCategory;
    private String lessonSchedule;
    private Long price;
    private String lessonDetailInfo;
    private Integer lessonLimited;

    private Integer lessonStatus;
}
