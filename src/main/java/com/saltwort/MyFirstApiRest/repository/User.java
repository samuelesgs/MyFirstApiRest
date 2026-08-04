package com.saltwort.MyFirstApiRest.repository;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String password;
    private Long type;
    @Column(name = "date_insert")
    private LocalDateTime dateInsert;
    @Column(name = "date_update")
    private LocalDateTime dateUpdate;
}
