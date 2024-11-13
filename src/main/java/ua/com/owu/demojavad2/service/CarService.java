package ua.com.owu.demojavad2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.owu.demojavad2.dto.CarDTO;
import ua.com.owu.demojavad2.entities.Car;
import ua.com.owu.demojavad2.mapper.CarMapper;
import ua.com.owu.demojavad2.repository.CarRepository;

import java.util.List;
import java.util.NoSuchElementException;

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

    public CarDTO addCar(CarDTO obtainedCarDTO) {
        Car addedCar = carMapper.mapToEntity(obtainedCarDTO);
        Car savedInRepCar = carRepository.save(addedCar);
        return carMapper.mapToDTO(savedInRepCar);
    }

    public CarDTO getById(int id) {
        Car car = carRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Car with this id is not found"));
        return carMapper.mapToDTO(car);
    }

    public List<Car> getCarslist(
            @RequestParam(name = "minEnginePower", required = false) Double minEnginePower,
            @RequestParam(name = "maxEnginePower", required = false) Double maxEnginePower
    ){
        if (minEnginePower != null && maxEnginePower != null) {
            return carRepository.findAllByEnginePowerBetween(minEnginePower, maxEnginePower);
        } else if (minEnginePower != null) {
            return carRepository.findAllByEnginePowerGreaterThan(minEnginePower);
        } else if (maxEnginePower != null) {
            return carRepository.findAllByEnginePowerLessThan(maxEnginePower);
        } else {
            return carRepository.findAll();
        }
    }

//    public List<CarDTO> getCarslist() {}

}
