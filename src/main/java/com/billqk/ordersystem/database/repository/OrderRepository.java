package com.billqk.ordersystem.database.repository;

import com.billqk.ordersystem.database.domain.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
