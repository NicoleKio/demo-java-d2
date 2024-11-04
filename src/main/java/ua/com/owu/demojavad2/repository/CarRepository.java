package ua.com.owu.demojavad2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.owu.demojavad2.entities.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByEnginePowerBetween(Double enginePower, Double enginePower2);

//    @Query("select c from Car c where c.enginePower > :minEnginePower and c.enginePower < :maxEnginePower)
//    List<Car> findAllByEnginePowerBetween

    List<Car> findAllByEnginePowerGreaterThan(Double minEnginePower);
    List<Car> findAllByEnginePowerLessThan(Double maxEnginePower);

}
