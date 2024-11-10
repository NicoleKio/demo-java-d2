package ua.com.owu.demojavad2.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarDTO {
    private int id;

    @NotEmpty
    private String model;

    @NotNull
    @Min(value = 500, message = "is too low")
    private int enginePower;

    private BigDecimal torque;
}
