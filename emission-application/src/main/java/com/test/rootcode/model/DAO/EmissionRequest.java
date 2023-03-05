package com.test.rootcode.model.DAO;

import com.test.rootcode.model.Emissions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmissionRequest  {

    private String sector;
    private Integer year;
    private String statistic;
    private String statisticCode;
    private String unit;
    private double value;

}
