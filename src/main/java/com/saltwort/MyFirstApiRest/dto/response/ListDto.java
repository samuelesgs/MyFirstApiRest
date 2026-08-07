package com.saltwort.MyFirstApiRest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListDto {
    private String detail;
    private Long disabled;
    private String name;
    private Long priority;
    private Long showAmount;
    private Long showHome;
    private Long fkUser;
}
