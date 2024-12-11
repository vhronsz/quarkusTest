package org.ryan;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CarService {
    @Inject
    CarRepository carRepository;

    public Car getCarById(Long id) {
        return carRepository.findById(id);
    }

    @Transactional
    public void createCar(Car car) {

        System.out.println("Car created: " + "xixixi");
    }
}


