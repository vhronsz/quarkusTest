package org.ryan;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CarRepository implements PanacheRepository<Car> {
    public Car findById(Long id) {
        return find("id", id).firstResult();
    }
}
