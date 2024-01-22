package com.store.onedaySeed.service;


import com.store.onedaySeed.entity.User;
import com.store.onedaySeed.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findOne(String userId) {
        return userRepository.findById(userId).orElseThrow(NullPointerException::new);
        // id에 해당하는 user가 repository에 존재하지 않을 경우 NullPointerException 에러 핸들링
    }
}
