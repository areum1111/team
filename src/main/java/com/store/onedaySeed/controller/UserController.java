package com.store.onedaySeed.controller;

import com.store.onedaySeed.dto.UserDto;
import com.store.onedaySeed.entity.User;
import com.store.onedaySeed.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Validated // @Valid 사용 위함
public class UserController {
    private final UserService userService;

    // 유저 상세 조회(프로필)
//    @GetMapping("/api/user/{userId}")
//    public UserDto userDetail(@PathVariable("userId") String userId) {
//        User user = userService.findOne(userId);
//        UserDto userDto = new UserDto(user);
//
//        return userDto;
//    }

    @GetMapping("/api/user")
    public UserDto userDetail() {
        User user = userService.findOne("hong");
        UserDto userDto = new UserDto(user);

        return userDto;
    }

    // 유저 정보 수정 // @Valid 의존성 추가하기
    @PostMapping("/api/user")
    public ResponseEntity<?> userUpdate(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
        // @Valid로 쿼리문 유효성 검사 >> userDto

        if(bindingResult.hasErrors()){ // 오류가 발생하였을 경우, 클라이언트에게 오류 메시지 전송
            Map<String, Object> errors = new HashMap<>();
            // 에러 메시지와 함께 alert 메시지 추가
            errors.put("alertMessage", "변경사항 저장에 실패했습니다.");
            errors.put("errors", bindingResult.getAllErrors());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        try {
            userService.updateUser(userDto);
            // 수정 성공시, 클라이언트에게 성공 메시지 전송
            Map<String, String> successResponse = new HashMap<>();
            successResponse.put("successMessage", "변경사항이 저장되었습니다.");
            successResponse.put("alertMessage", "변경사항이 저장되었습니다.");

            return ResponseEntity.ok(successResponse);

        } catch (Exception e){
            Map<String, String> errors = new HashMap<>();
            // 에러 메시지와 함께 alert 메시지 추가
            errors.put("alertMessage", "변경사항 저장에 실패했습니다.");
            errors.put("errorMessage", e.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }
    }

    @GetMapping("/api/test")
    public String hello() {
        return "테스트입니다.";
    }
}
