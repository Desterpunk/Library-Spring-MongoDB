package com.sofkau.Library.routers;

import com.sofkau.Library.dtos.ResourceDTO;
import com.sofkau.Library.usecases.FindResourceByTypeAndAreaUseCase;
import com.sofkau.Library.usecases.FindResourceByTypeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FindResourceByTypeAndAreaRouter {

    @Bean
    public RouterFunction<ServerResponse> getResourceByTypeAndArea(FindResourceByTypeAndAreaUseCase findResourceByTypeAndAreaUseCase){
        return route(GET("/library/bytypeandarea/{type}/{area}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .body(findResourceByTypeAndAreaUseCase.apply(request.pathVariable("type"), request.pathVariable("area")), ResourceDTO.class));
    }
}