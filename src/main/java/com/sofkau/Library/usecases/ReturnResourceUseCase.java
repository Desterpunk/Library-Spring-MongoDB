package com.sofkau.Library.usecases;

import com.sofkau.Library.mappers.ResourceMapper;
import com.sofkau.Library.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
public class ReturnResourceUseCase implements ReturnResource{
    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;
    private final UpdateResourceUseCase updateResourceUseCase;

    @Autowired
    public ReturnResourceUseCase(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
        this.updateResourceUseCase = new UpdateResourceUseCase(resourceRepository,resourceMapper);
    }

    @Override
    public Mono<String> apply(String id) {
        return resourceRepository.findById(id).flatMap(
                resource -> {
                    if (!resource.getAvaible()){
                        resource.setDate(LocalDate.now());
                        resource.setAvaible(true);
                        return updateResourceUseCase.apply(resourceMapper.mapEntityToDTO().apply(resource)).thenReturn(resource.getName() + " successfully returned");
                    }
                    return Mono.just(resource.getName() + " that's no the original copy");
                }
        );
    }
}