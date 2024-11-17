package ua.com.owu.demojavad2.dto;

import jakarta.persistence.Enumerated;
import lombok.Data;
import ua.com.owu.demojavad2.entities.ProductAvailability;

@Data
public class ProductDTO {
    private int id;

    private String name;

    private Double price;

    private ProductAvailability availability;
}
