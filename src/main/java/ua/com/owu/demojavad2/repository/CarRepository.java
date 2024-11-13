package ua.com.owu.demojavad2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.owu.demojavad2.entities.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findAllByEnginePowerBetween(Double enginePower, Double enginePower2);

    List<Car> findAllByEnginePowerGreaterThan(Double minEnginePower);
    List<Car> findAllByEnginePowerLessThan(Double maxEnginePower);

}
