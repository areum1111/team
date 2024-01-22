package com.store.onedaySeed.repository;


import com.store.onedaySeed.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

public interface CartRepository extends JpaRepository<Cart, Long> {
}