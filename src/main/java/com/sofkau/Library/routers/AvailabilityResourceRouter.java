package com.sofkau.Library.routers;

import com.sofkau.Library.dtos.StatusDTO;
import com.sofkau.Library.usecases.AvailabilityResourceUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class AvailabilityResourceRouter {
    @Bean
    public RouterFunction<ServerResponse> availabilityResource(AvailabilityResourceUseCase availabilityResourceUseCase){
        return route(GET("/library/availability/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .body(availabilityResourceUseCase.apply(request.pathVariable("id")), StatusDTO.class));
    }
}
