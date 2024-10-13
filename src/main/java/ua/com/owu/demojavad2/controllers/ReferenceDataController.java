package ua.com.owu.demojavad2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.com.owu.demojavad2.properties.ReferenceDataProperties;
import ua.com.owu.demojavad2.properties.Fuel;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/asd")
public class ReferenceDataController {
    //    @Value("${reference-data.engineTypes}")
//    private List<String> engines;
    private final ReferenceDataProperties referenceDataProperties;

    @GetMapping("/engine-types")
    public ResponseEntity<List<String>> getEngineTypes() {
        return ResponseEntity.ok(referenceDataProperties.getEngineTypes());
    }

    @GetMapping("/fuel-types")
    public ResponseEntity<List<Fuel>> getFuelTypes() {
        return ResponseEntity.ok(referenceDataProperties.getFuels());
    }

    @GetMapping("/fuel-types/{name}")
    public ResponseEntity<Fuel> getFuelType(@PathVariable String name) {
        Optional<Fuel> result = Optional
                .ofNullable(referenceDataProperties)
                .map(ReferenceDataProperties::getFuels)
                .stream()
                .flatMap(Collection::stream)
                .filter(fuel -> Objects.equals(fuel.getName(), name))
                .findFirst();
        return ResponseEntity.of(result);
    }
}

