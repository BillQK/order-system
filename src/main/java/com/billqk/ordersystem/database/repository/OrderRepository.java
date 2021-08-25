package com.billqk.ordersystem.database.repository;

import com.billqk.ordersystem.constant.Constant;
import com.billqk.ordersystem.database.domain.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByStatus (Constant.Status status);
}
