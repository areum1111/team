package com.store.onedaySeed.dto;

import com.store.onedaySeed.constant.LessonStatus;
import com.store.onedaySeed.entity.Lesson;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class LessonRegisterDto {

    private Long lessonId;
    @NotBlank(message = "레슨명은 필수입니다.")
    private String lessonName;
    @NotBlank(message = "카테고리 설정은 필수입니다.")
    private String lessonCategory;
    @NotBlank(message = "레슨 시작일 설정은 필수입니다.")
    private String lessonSchedule;
    @NotNull(message = "가격 입력은 필수입니다.")
    private Long price;
    @NotBlank(message = "최대 인원 설정은 필수입니다.")
    private Integer lessonLimited;

    private LessonStatus lessonStatus;
    //private List<LessonImgDto> lessonImgDtoList = new ArrayList<>();
    //private List<Long> lessonImgIds = new ArrayList<>();
    private static ModelMapper modelMapper = new ModelMapper();
    public Lesson createLesson(){
        return modelMapper.map(this, Lesson.class);
    }

    public static LessonRegisterDto of(Lesson lesson){
        return modelMapper.map(lesson, LessonRegisterDto.class);
    }


}
