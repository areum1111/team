package com.store.onedaySeed.controller;

import com.store.onedaySeed.dto.UserDto;
import com.store.onedaySeed.entity.User;
import com.store.onedaySeed.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
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

    @GetMapping("/api/test")
    public String hello() {
        return "테스트입니다.";
    }
}
