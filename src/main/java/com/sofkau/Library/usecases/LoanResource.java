package com.sofkau.Library.usecases;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface LoanResource {
    public Mono<String> apply(String id);
}
