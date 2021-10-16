package com.sofkau.Library.usecases;

import com.sofkau.Library.mappers.ResourceMapper;
import com.sofkau.Library.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AvailabilityResourceUseCase implements AvailabilityResource {
    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    @Autowired
    public AvailabilityResourceUseCase(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public Mono<String> apply(String id) {
        return resourceRepository.findById(id).map(
                resource -> resource.getAvaible() ?
                        String.valueOf(resource.getName() + " is available") :
                        String.valueOf(resource.getName() +" is not available" + " last date " + resource.getDate())
        );
    }
}
