package com.billqk.ordersystem.database.repository;

import com.billqk.ordersystem.database.domain.OrderDetailsEntity;
import com.billqk.ordersystem.database.domain.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity, Long> {
    List<OrderDetailsEntity> findByOrderEntity(OrderEntity orderEntity);

    @Transactional
    Long deleteByOrderEntity(OrderEntity orderEntity);
}
