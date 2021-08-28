package com.billqk.ordersystem.service.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
    public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
        Optional<ConfirmationToken> findByToken(String token);
}
