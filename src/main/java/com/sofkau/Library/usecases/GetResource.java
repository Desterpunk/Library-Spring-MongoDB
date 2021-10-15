package com.sofkau.Library.usecases;

import com.sofkau.Library.dtos.ResourceDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface GetResource {
    public Mono<ResourceDTO> findById(String id);
}
