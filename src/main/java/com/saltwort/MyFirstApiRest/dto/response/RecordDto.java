package com.saltwort.MyFirstApiRest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordDto {
    private Long id;
    private double amount;
    private Long complete;
    private String name;
    private double currentRecords;
    private double totalRecords;
    private Long fkList;
}
