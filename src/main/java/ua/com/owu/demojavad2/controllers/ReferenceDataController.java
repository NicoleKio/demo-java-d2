package ua.com.owu.demojavad2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.com.owu.demojavad2.properties.ReferenceDataProperties;
import ua.com.owu.demojavad2.properties.Weapon;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ReferenceDataController {
    public final ReferenceDataProperties referenceDataProperties;

    @GetMapping("/race-types")
    public ResponseEntity<List<String>> getRaceTypes() {
        return ResponseEntity.ok(referenceDataProperties.getRaceTypes());
    }

    @GetMapping("/weapon-instances")
    public ResponseEntity<List<Weapon>> getWeaponInstances() {
        return ResponseEntity.ok(referenceDataProperties.getWeapons());
    }

    @GetMapping("/weapon-instances/{name}")
    public ResponseEntity<Weapon> getWeaponInstance(@PathVariable String name) {
        Optional<Weapon> result = Optional
                .ofNullable(referenceDataProperties)
                .map(ReferenceDataProperties::getWeapons)
                .stream()
                .flatMap(Collection::stream)
                .filter(weapon -> Objects.equals(weapon.getName(), name))
                .findFirst();

        return ResponseEntity.of(result);
    }
}

