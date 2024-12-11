package org.ryan.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.ryan.Entity.Car;

import java.util.List;

@ApplicationScoped
public class CarRepository implements PanacheRepository<Car> {
    public Car findById(Long id) {
        return find("id", id).firstResult();
    }

    public List<Car> findAllCar(){
        return findAll().list();
    }

    public Car save(Car car) {
        car.persistAndFlush();
        return car;
    }
}
