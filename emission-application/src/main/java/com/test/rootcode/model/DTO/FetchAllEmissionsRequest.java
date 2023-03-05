package com.test.rootcode.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FetchAllEmissionsRequest {
    private String sector;
    private String year;
    private String statistic_code;
    private String statistic;
    private String unit;
    private String value;

}
