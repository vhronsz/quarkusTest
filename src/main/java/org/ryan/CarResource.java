package org.ryan;

import io.quarkus.vertx.web.Param;
import io.quarkus.vertx.web.Route;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Objects;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {

    @Inject
    CarService carService;

    @GET
    @Path("/{id}")
    public Car get(@PathParam("id") Long id) {
        return carService.getCarById(id);
    }
//    @Route(path = "/car", methods = Route.HttpMethod.GET)
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<CarDto> getAll() {
//        return null;
//    }

    //    @Route(path= "/car/create", methods = Route.HttpMethod.POST)
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Car create(Car car) {
        carService.createCar(car);
        return car;
    }

}
