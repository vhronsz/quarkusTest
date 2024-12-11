package org.ryan.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;


/**
 * Example JPA entity defined as a Panache Entity.
 * An ID field of Long type is provided, if you want to define your own ID field extends <code>PanacheEntityBase</code> instead.
 *
 * This uses the active record pattern, you can also use the repository pattern instead:
 * .
 *
 * Usage (more example on the documentation)
 *
 * {@code
 *     public void doSomething() {
 *         MyEntity entity1 = new MyEntity();
 *         entity1.field = "field-1";
 *         entity1.persist();
 *
 *         List<MyEntity> entities = MyEntity.listAll();
 *     }
 * }
 */
@Entity
@Table(name = "cars")
public class Car extends PanacheEntityBase {
    @Id
    public long id;

    public String brand;
    public String color;

    public double price;
    public String price_unit;

    public int speed;
    public String speed_unit;

    public Car(){}
    public Car(long id, String brand, String color, double price, String price_unit, int speed, String speed_unit) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.price_unit = price_unit;
        this.speed = speed;
        this.speed_unit = speed_unit;
    }
}
