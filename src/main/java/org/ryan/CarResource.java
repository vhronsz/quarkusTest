package org.ryan;

import io.quarkus.vertx.web.Param;
import io.quarkus.vertx.web.Route;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Objects;

public class CarResource {
    @Route(path = "/:id", methods = Route.HttpMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public Long get(
            @Param Long id
    ) {
        if(Objects.isNull(id)){
            return (long) -999;
        }
        return (long) 10;
    }

    @Route(path = "car", methods = Route.HttpMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public Long getAll() {
        return (long) 100;
    }
}
