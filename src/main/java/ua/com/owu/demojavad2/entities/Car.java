package ua.com.owu.demojavad2.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Entity
@Data
@Component
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private int enginePower;

    private BigDecimal torque;

}
