package ua.com.owu.demojavad2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.owu.demojavad2.dto.CarDTO;
import ua.com.owu.demojavad2.entities.Car;
import ua.com.owu.demojavad2.mapper.CarMapper;
import ua.com.owu.demojavad2.repository.CarRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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



    public List<CarDTO> getCarslist(Double minEnginePower, Double maxEnginePower){

        List<Car> cars;

       if(minEnginePower != null && maxEnginePower != null){
           cars = carRepository.findAllByEnginePowerBetween(minEnginePower, maxEnginePower);
       } else if (minEnginePower != null) {
           cars = carRepository.findAllByEnginePowerGreaterThan(minEnginePower);
       }else if(maxEnginePower != null){
           cars = carRepository.findAllByEnginePowerLessThan(maxEnginePower);
       } else {
           cars = carRepository.findAll();
       }
        return cars.stream()
                .map(carMapper::mapToDTO)
                .collect(Collectors.toList());
    }



    public CarDTO updateCar(int id, CarDTO carUpdatedDTO) {
        Car car = carRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Car didn't update. Check its id."));
        car.setModel(carUpdatedDTO.getModel());
        car.setEnginePower(carUpdatedDTO.getEnginePower());
        car.setTorque(carUpdatedDTO.getTorque());
//        return carMapper.mapToDTO(carRepository.save(car));
        Car savedInRepCar = carRepository.save(car);
        return carMapper.mapToDTO(savedInRepCar);
    }


    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }

}

