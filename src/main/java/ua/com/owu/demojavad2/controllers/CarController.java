package ua.com.owu.demojavad2.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.demojavad2.entities.Car;
import ua.com.owu.demojavad2.properties.CarProperties;

import java.util.*;

@RestController
@AllArgsConstructor
public class CarController {
    private final CarProperties carProperties;

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getCars() {
        return ResponseEntity.ok(carProperties.getCars());
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCar(@PathVariable int id) {
        Optional<Car> currentCar = Optional
                .ofNullable(carProperties)
                .map(CarProperties::getCars)
                .stream()
                .flatMap(Collection::stream)
                .filter(car -> Objects.equals(car.getId(), id))
                .findFirst();
        return ResponseEntity.of(currentCar);
    }

    @PostMapping("/cars")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        return ResponseEntity.ok(carProperties.getCars().set(car.getId(), car));
    }






}
