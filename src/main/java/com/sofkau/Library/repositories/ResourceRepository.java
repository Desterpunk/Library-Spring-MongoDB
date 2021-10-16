package com.sofkau.Library.repositories;

import com.sofkau.Library.models.Resource;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface ResourceRepository extends ReactiveCrudRepository<Resource,String> {
    Flux<Resource> findResourcesByArea(String area);
    Flux<Resource> findResourcesByType(String type);
    Flux<Resource> findResourcesByTypeAndArea(String type, String area);
}
