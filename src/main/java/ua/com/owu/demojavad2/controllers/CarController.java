package ua.com.owu.demojavad2.controllers;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.demojavad2.dto.CarDTO;
import ua.com.owu.demojavad2.entities.Car;
import ua.com.owu.demojavad2.mapper.CarMapper;
import ua.com.owu.demojavad2.repository.CarRepository;

import java.util.*;

@RestController
@AllArgsConstructor
public class CarController {

    private final CarRepository carRepository;
    private final CarMapper carMapper;


//    @GetMapping("/cars")
//    public ResponseEntity<List<Car>> getCars() {
//        return ResponseEntity.ok(carRepository.findAll());
//
//    }
    @GetMapping("/cars")
    public ResponseEntity<List<CarDTO>> getCars() {
        return ResponseEntity
                .ok(carRepository
                        .findAll()
                        .stream()
                        .map(carMapper::mapToDTO)
                        .toList());
    }

//    @PostMapping("/cars")
//    public Car createCar(@RequestBody Car car) {
//        return carRepository.save(car);
//    }

    @PostMapping("/cars")
    public ResponseEntity<CarDTO> addCar(@RequestBody CarDTO dto) {
        Car savedCar = carMapper.mapToEntity(dto);
        CarDTO carDTO = carMapper.mapToDTO(savedCar);
        return ResponseEntity.ok(carDTO);
    }


    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id) {
        return ResponseEntity.of(carRepository.findById(id));
    }

    @GetMapping("/carslist")
    public ResponseEntity<List<Car>> getCarslist(
            @RequestParam(name = "minEnginePower", required = false) Double minEnginePower,
            @RequestParam(name = "maxEnginePower", required = false) Double maxEnginePower
    ) {

        if (minEnginePower != null && maxEnginePower != null) {
            return ResponseEntity.ok(carRepository.findAllByEnginePowerBetween(minEnginePower, maxEnginePower));
        } else if (minEnginePower != null) {
            return ResponseEntity.ok(carRepository.findAllByEnginePowerGreaterThan(minEnginePower));
        } else if (maxEnginePower != null) {
            return ResponseEntity.ok(carRepository.findAllByEnginePowerLessThan(maxEnginePower));
        } else {
            return ResponseEntity.ok(carRepository.findAll());
        }
    }

    @Transactional
    @PutMapping("/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable(name = "id") Long carId, @RequestBody Car car) {
        return ResponseEntity.of(
                carRepository.findById(carId)
                        .map(oldCar -> {
                            oldCar.setModel(car.getModel());
                            oldCar.setEnginePower(car.getEnginePower());
                            oldCar.setTorque(car.getTorque());
                            return oldCar;
                        })
        );
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable Long id) {
        carRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
