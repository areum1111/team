package com.store.onedaySeed.service;

import com.store.onedaySeed.dto.LessonDto;
import com.store.onedaySeed.dto.LessonRegisterDto;
import com.store.onedaySeed.entity.Lesson;
import com.store.onedaySeed.entity.LessonImg;
//import com.store.onedaySeed.repository.LessonImgRepository;
import com.store.onedaySeed.repository.LessonRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;

    public Long saveLesson(LessonRegisterDto lessonRegisterDto){
        Lesson lesson = lessonRegisterDto.createLesson();
        lessonRepository.save(lesson);

        return lesson.getLessonId();
    }

}
