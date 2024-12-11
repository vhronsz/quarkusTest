package org.ryan;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class CarService {
    @Inject
    CarRepository carRepository;

    public Car getCarById(Long id) {
        return carRepository.findById(id);
    }

    public List<Car> findAllCar() {
        return carRepository.findAllCar();
    }

    @Transactional
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(Car car, String brand, Double price) {
        if(Objects.nonNull(brand)){
            car.brand = brand;
        }

        if(Objects.nonNull(price)){
            car.price = price;
        }
        return carRepository.save(car);
    }
}


