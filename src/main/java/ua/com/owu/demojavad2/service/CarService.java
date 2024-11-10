package ua.com.owu.demojavad2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.com.owu.demojavad2.dto.CarDTO;
import ua.com.owu.demojavad2.entities.Car;
import ua.com.owu.demojavad2.mapper.CarMapper;
import ua.com.owu.demojavad2.repository.CarRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public List<CarDTO> getCars() {
        return carRepository
                .findAll()
                .stream()
                .map(carMapper::mapToDTO)
                .toList();
    }

    public CarDTO addCar(CarDTO sourceCarDTO) {
        Car car = carMapper.mapToEntity(sourceCarDTO);
        Car savedCar = carMapper.mapToEntity(car);
        CarDTO carDTO = carMapper.mapToDTO(savedCar);
        return ResponseEntity.ok();
    }
}
