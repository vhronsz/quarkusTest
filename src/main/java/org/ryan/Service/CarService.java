package org.ryan.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.ryan.Entity.Car;
import org.ryan.Repository.CarRepository;

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

    @Transactional
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


