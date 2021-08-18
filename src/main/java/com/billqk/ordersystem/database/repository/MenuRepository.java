package com.billqk.ordersystem.database.repository;

import com.billqk.ordersystem.database.domain.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
}
