package com.sofkau.Library.usecases;

import com.sofkau.Library.dtos.StatusDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface AvailabilityResource {
    public Mono<StatusDTO> apply(String id);
}
