package ua.com.owu.demojavad2.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarDTO {
    private int id;
    private String model;
    private int enginePower;

    private BigDecimal torque;
}
