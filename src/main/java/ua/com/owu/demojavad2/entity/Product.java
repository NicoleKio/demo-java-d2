package ua.com.owu.demojavad2.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name= "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Double price;

    @Enumerated(EnumType.ORDINAL)
    private ProductAvailability availability;
}
