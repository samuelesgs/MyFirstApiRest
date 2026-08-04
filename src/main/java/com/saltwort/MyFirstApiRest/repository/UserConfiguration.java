package com.saltwort.MyFirstApiRest.repository;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_configurations")
@Data
public class UserConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long theme;
    private Long language;
    private Long notification;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user", nullable = false)
    private User user;
    @Column(name = "date_update")
    private LocalDateTime dateUpdate;
}
