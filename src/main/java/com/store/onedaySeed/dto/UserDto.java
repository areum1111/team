package com.store.onedaySeed.dto;

import com.store.onedaySeed.constant.Role;
import com.store.onedaySeed.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private String userId;

    private String userName;

    private Long phoneNum;

    private String password;

    public UserDto(User user) {
    this.userId = user.getUserId();
    this.userName = user.getUserName();
    this.phoneNum = user.getPhoneNum();
    this.password = user.getPassword();
    }
}
