package com.store.onedaySeed.repository;

import com.store.onedaySeed.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}