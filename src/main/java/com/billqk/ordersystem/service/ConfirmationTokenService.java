package com.billqk.ordersystem.service;

import com.billqk.ordersystem.database.domain.ConfirmationToken;
import com.billqk.ordersystem.database.repository.ConfirmationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ConfirmationTokenService {
    @Autowired
    ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }
}
