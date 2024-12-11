package org.ryan;

import io.quarkus.vertx.web.Param;
import io.quarkus.vertx.web.Route;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestResponse;

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
    public RestResponse get(@PathParam("id") Long id) {
        return RestResponse.ok(carService.getCarById(id));
    }

    @GET
    public RestResponse getAll() {
        return RestResponse.ok(carService.findAllCar());
    }

    @POST
    public RestResponse create(Car car) {
        try {
            return RestResponse.ok(carService.createCar(car));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return RestResponse.status(Response.Status.BAD_REQUEST, e.getMessage());
        }
    }

    @PUT
    @Path("/{id}")
    public RestResponse update(@PathParam("id") Long id, String brand, Double price) {
        Car car = carService.getCarById(id);
        if(Objects.isNull(car)){
            return RestResponse.status(Response.Status.NOT_FOUND, "Car not found");
        }

        if(Objects.isNull(brand) && Objects.isNull(price) ){
            return RestResponse.status(422, "Brand or Price is null");
        }

        try{
            return RestResponse.ok(carService.updateCar(car, brand, price));
        }catch (Exception e){
            return RestResponse.status(Response.Status.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
