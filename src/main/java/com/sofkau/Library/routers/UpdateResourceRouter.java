package com.sofkau.Library.routers;

import com.sofkau.Library.dtos.ResourceDTO;
import com.sofkau.Library.usecases.UpdateResourceUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateResourceRouter {

    @Bean
    public RouterFunction<ServerResponse> updateResource(UpdateResourceUseCase updateResourceUseCase){
        return route(PUT("/library").and(accept(MediaType.APPLICATION_JSON)),
                request ->request.bodyToMono(ResourceDTO.class)
                        .flatMap(recursoDTO -> updateResourceUseCase.apply(recursoDTO)
                                .flatMap(result->ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result)))
        );
    }
}
