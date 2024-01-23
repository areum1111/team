package com.store.onedaySeed.entity;

import com.store.onedaySeed.constant.Role;
import com.store.onedaySeed.dto.UserDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

@Entity
@Table(name="user")
@Getter
@Setter
@ToString
public class User extends BaseEntity{

    @Id
    @Column(name="user_id" ,unique = true)
    private String userId;

    @Column(nullable = false,name="user_name")
    private String userName;

    @Column(nullable = false,name="phone_num")
    private String phoneNum;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public void updateUser(UserDto userDto) {
        this.userId = userDto.getUserId();
        this.userName = userDto.getUserName();
        this.phoneNum = userDto.getPhoneNum();
        this.password = userDto.getPassword();
    }

}
