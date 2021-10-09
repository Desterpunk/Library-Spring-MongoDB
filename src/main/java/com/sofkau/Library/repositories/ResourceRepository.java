package com.sofkau.Library.repositories;

import com.sofkau.Library.models.Resource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends MongoRepository<Resource,String> {
}
