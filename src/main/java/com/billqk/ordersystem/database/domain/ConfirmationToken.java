package com.billqk.ordersystem.database.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {

    @Id
    @SequenceGenerator(
            name = "confirmation_token_sequence",
            sequenceName = "confirmation_token_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "confirmation_token_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiredAt;

    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "user_id"
    )
    private UserEntity userEntity;

    public ConfirmationToken(String token,
                             LocalDateTime createdAt,
                             LocalDateTime expiredAt,
                             UserEntity userEntity) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.userEntity = userEntity;
    }
}



