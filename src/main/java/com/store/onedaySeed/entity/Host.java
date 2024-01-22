package com.store.onedaySeed.entity;

import com.store.onedaySeed.constant.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

@Entity
@Table(name="host")
@Getter
@Setter
@ToString
public class Host extends BaseEntity{

    @Id
    @Column(name = "host_num", unique = true)
    private String hostNum;

    @Column(nullable = false, name="host_name")
    private String hostName;

    @Column(nullable = false, name="phone_num")
    private Long phoneNum;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


}
