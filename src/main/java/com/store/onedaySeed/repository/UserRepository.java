package com.store.onedaySeed.repository;

import com.store.onedaySeed.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
