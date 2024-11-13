package ua.com.owu.demojavad2.controllers;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.demojavad2.dto.CarDTO;
import ua.com.owu.demojavad2.entities.Car;
import ua.com.owu.demojavad2.service.CarService;

import java.util.*;

@RestController
@AllArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @GetMapping()
    public ResponseEntity<List<CarDTO>> getCars() {
        return ResponseEntity.ok(carService.getCars());
    }

    @PostMapping()
    public ResponseEntity<CarDTO> addCar(@RequestBody @Valid CarDTO carDTO) {
        return ResponseEntity.ok(carService.addCar(carDTO));
    }


    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCar(@PathVariable int id) {
        return ResponseEntity.ok(carService.getById(id));
    }


//    @GetMapping("/carslist")
//    public ResponseEntity<List<Car>> getCarslist(
//            @RequestParam(name = "minEnginePower", required = false) Double minEnginePower,
//            @RequestParam(name = "maxEnginePower", required = false) Double maxEnginePower
//    ) {
//
//        if (minEnginePower != null && maxEnginePower != null) {
//            return ResponseEntity.ok(carRepository.findAllByEnginePowerBetween(minEnginePower, maxEnginePower));
//        } else if (minEnginePower != null) {
//            return ResponseEntity.ok(carRepository.findAllByEnginePowerGreaterThan(minEnginePower));
//        } else if (maxEnginePower != null) {
//            return ResponseEntity.ok(carRepository.findAllByEnginePowerLessThan(maxEnginePower));
//        } else {
//            return ResponseEntity.ok(carRepository.findAll());
//        }
//    }

    @GetMapping("/carslist")
    public ResponseEntity<List<Car>> getCarslist(
            @RequestParam(name = "minEnginePower", required = false) Double minEnginePower,
            @RequestParam(name = "maxEnginePower", required = false) Double maxEnginePower
    ) {
        return ResponseEntity.ok(carService.getCarslist(minEnginePower, maxEnginePower));
    }



//    @Transactional
//    @PutMapping("/cars/{id}")
//    public ResponseEntity<CarDTO> updateCar(@PathVariable(name = "id") Long carId, @RequestBody Car car) {
//        return ResponseEntity.of(
//                carRepository.findById(carId)
//                        .map(oldCar -> {
//                            oldCar.setModel(car.getModel());
//                            oldCar.setEnginePower(car.getEnginePower());
//                            oldCar.setTorque(car.getTorque());
//                            return oldCar;
//                        })
//        );
//    }
//
//    @DeleteMapping("/cars/{id}")
//    public ResponseEntity<Car> deleteCar(@PathVariable Long id) {
//        carRepository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }



}
