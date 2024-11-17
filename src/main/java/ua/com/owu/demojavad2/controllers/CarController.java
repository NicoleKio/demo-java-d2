package ua.com.owu.demojavad2.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.demojavad2.dto.CarDTO;
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


    @GetMapping("/carslist")
    public ResponseEntity<List<CarDTO>> getCarslist(
            @RequestParam(name = "minEnginePower", required = false) Double minEnginePower,
            @RequestParam(name = "maxEnginePower", required = false) Double maxEnginePower
    ) {
        return ResponseEntity.ok(carService.getCarslist(minEnginePower, maxEnginePower));
    }


    @PutMapping("/{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable int id, @RequestBody @Valid CarDTO carUpdatedDTO) {
        return ResponseEntity.ok(carService.updateCar(id, carUpdatedDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarDTO> deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

}
