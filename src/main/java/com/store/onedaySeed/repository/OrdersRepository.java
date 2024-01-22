package com.store.onedaySeed.repository;

import com.store.onedaySeed.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}