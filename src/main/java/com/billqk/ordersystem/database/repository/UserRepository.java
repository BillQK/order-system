package com.billqk.ordersystem.database.repository;

import com.billqk.ordersystem.database.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE UserEntity a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUserEntity(String email);
}
