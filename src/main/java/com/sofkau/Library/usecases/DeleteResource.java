package com.sofkau.Library.usecases;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DeleteResource {
    public Mono<Void> delete(String id);
}
