package com.sofkau.Library.usecases;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ReturnResource {
    public Mono<String> apply(String id);
}