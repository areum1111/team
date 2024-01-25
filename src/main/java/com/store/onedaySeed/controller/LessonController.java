package com.store.onedaySeed.controller;

//import com.store.onedaySeed.dto.LessonDto;
//import com.store.onedaySeed.dto.LessonRegisterDto;
import com.store.onedaySeed.entity.Lesson;
//import com.store.onedaySeed.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/lesson")
public class LessonController {

//    private final LessonService lessonService;
//
//    @Autowired
//    public LessonController(LessonService lessonService){
//        this.lessonService = lessonService;
//    }
//
//    @GetMapping(value = "/test")
//    public String test(){
//        return "테스트니까 입력 ㄴㄴ";
//    }

//    @PostMapping(value = "/new")
//    public ResponseEntity<LessonDto> lessonRegister(@RequestBody LessonDto lessonDto) {
//
//        return ResponseEntity.ok(lessonDto);
//    }

//    @GetMapping(value = "/new")
//    public void lessonRegister(
//            @RequestParam String lessonName,
//            @RequestParam String lessonCategory,
//            @RequestParam Long lessonPrice,
//            @RequestParam Long lessonLimited,
//            @RequestParam String lessonStatus){
//        System.out.println(lessonName);
//        System.out.println(lessonCategory);
//        System.out.println(lessonPrice);
//        System.out.println(lessonLimited);
//        System.out.println(lessonStatus);
//    }

    public static class LessonRequest {
        private String lessonName;
        private String lessonCategory;
        private Long lessonPrice;
        private Integer lessonLimited;
        private String lessonStatus;
    }
    @PostMapping(value = "/new")
    public ResponseEntity<String> lessonRegister(@RequestBody LessonRequest lessonRequest){
//        System.out.println(lessonName);
//        System.out.println(lessonCategory);
//        System.out.println(lessonPrice);
//        System.out.println(lessonLimited);
//        System.out.println(lessonStatus);
        return ResponseEntity.ok("Lesson saved successfully");
    }
}
