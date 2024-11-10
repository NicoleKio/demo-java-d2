package ua.com.owu.demojavad2.mapper;

import org.springframework.stereotype.Component;
import ua.com.owu.demojavad2.dto.CarDTO;
import ua.com.owu.demojavad2.entities.Car;


@Component
public class CarMapper {

    public Car mapToEntity(CarDTO dto) {
        Car car = new Car();

        car.setId(dto.getId());
        car.setModel(dto.getModel());
        car.setEnginePower(dto.getEnginePower());
        car.setTorque(dto.getTorque());

        if (car.getEnginePower() < 1){
            throw new IllegalArgumentException("Engine power is less than 0");
        }
        return car;
    }

    public CarDTO mapToDTO (Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setModel(car.getModel());
        carDTO.setEnginePower(car.getEnginePower());
        carDTO.setTorque(car.getTorque());
        return carDTO;
    }
}
