package com.sofkau.Library.usecases;

import com.sofkau.Library.dtos.ResourceDTO;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface FindResourceByTypeAndArea {
    Flux<ResourceDTO> apply(String type,String area);
}
