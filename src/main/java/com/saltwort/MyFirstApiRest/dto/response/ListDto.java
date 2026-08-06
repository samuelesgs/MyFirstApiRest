package com.saltwort.MyFirstApiRest.dto.response;

import com.saltwort.MyFirstApiRest.model.User;
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
    private User user;
}
