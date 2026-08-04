package com.saltwort.MyFirstApiRest.repository;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "lists")
@Data
public class List {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String detail;
    @Column(name = "show_amount")
    private Long showAmount;
    @Column(name = "show_home")
    private Long showHome;
    private Long disabled;
    private Long priority;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user", nullable = false)
    private User user;
    @Column(name = "date_update")
    private LocalDateTime dateUpdate;
    @Column(name = "date_insert")
    private LocalDateTime dateInsert;

}
