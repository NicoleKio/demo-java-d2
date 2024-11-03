package ua.com.owu.demojavad2.properties;

import lombok.Data;
import org.springframework.stereotype.Component;
import ua.com.owu.demojavad2.entities.Car;

import java.util.List;

@Data
@Component
public class CarProperties {
    private List<Car> cars;
}
