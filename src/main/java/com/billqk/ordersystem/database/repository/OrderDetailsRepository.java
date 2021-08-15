package com.billqk.ordersystem.database.repository;

import com.billqk.ordersystem.database.domain.OrderDetailsEntity;
import com.billqk.ordersystem.database.domain.OrderEntity;
import com.billqk.ordersystem.model.OrderDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity, Long> {
    List<OrderDetailsEntity> findByOrderEntity(OrderEntity orderEntity);
}
