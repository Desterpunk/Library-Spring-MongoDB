package com.sofkau.Library.usecases;

import com.sofkau.Library.dtos.ResourceDTO;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface FindResourceByType {
    Flux<ResourceDTO> apply(String type);
}
