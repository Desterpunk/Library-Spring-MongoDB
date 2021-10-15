package com.sofkau.Library.repositories;

import com.sofkau.Library.models.Resource;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepository extends ReactiveMongoRepository<Resource,String> {
    Optional<List<Resource>> findResourcesByType(String type);
    Optional<List<Resource>> findResourcesByArea(String area);
    Optional<List<Resource>> findResourcesByTypeAndArea(String type, String area);
}
