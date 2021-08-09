package com.billqk.ordersystem.database.repository;


import com.billqk.ordersystem.database.domain.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
