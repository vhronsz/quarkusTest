package org.ryan;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestResponse;
import org.ryan.Entity.Car;
import org.ryan.Request.UpdateCarRequest;
import org.ryan.Service.CarService;

import java.util.Objects;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {
    @Inject
    CarService carService;

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        return Response.ok(carService.getCarById(id)).build();
    }

    @GET
    public Response getAll() {
        return Response.ok(carService.findAllCar()).build();
    }

    @POST
    public Response create(Car car) {
        try {
            return Response.ok(carService.createCar(car)).build();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") Long id, UpdateCarRequest request) {
        Car car = carService.getCarById(id);
        if(Objects.isNull(car)){
            return Response.status(Response.Status.NOT_FOUND).entity("Car not found").build();
        }

        if(Objects.isNull(request) || Objects.isNull(request.brand) && Objects.isNull(request.price) ){
            return Response.status(422).entity("Brand or Price is null").build();
        }

        try{
            return Response.ok(carService.updateCar(car, request.brand, request.price)).build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
