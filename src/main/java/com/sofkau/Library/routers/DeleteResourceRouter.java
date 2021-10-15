package com.sofkau.Library.routers;

import com.sofkau.Library.dtos.ResourceDTO;
import com.sofkau.Library.usecases.DeleteResourceUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteResourceRouter {

    @Bean
    public RouterFunction<ServerResponse> deleteResource(DeleteResourceUseCase deleteResourceUseCase){
        return route(DELETE("/library/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .body(deleteResourceUseCase.delete(request.pathVariable("id")), ResourceDTO.class));
    }
}
