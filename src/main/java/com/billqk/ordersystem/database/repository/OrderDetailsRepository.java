package com.billqk.ordersystem.database.repository;

import com.billqk.ordersystem.database.domain.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity, Long> {
}
