package com.saltwort.MyFirstApiRest.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "records")
@Data
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long complete;
    private double amount;
    @Column(name = "current_records")
    private double currentRecords;
    @Column(name = "total_records")
    private double totalRecords;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_list", nullable = false)
    private List list;
    @Column(name = "date_update")
    private LocalDateTime dateUpdate;
    @Column(name = "date_insert")
    private LocalDateTime dateInsert;
}
