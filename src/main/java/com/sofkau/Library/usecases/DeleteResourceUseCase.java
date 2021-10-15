package com.sofkau.Library.usecases;

import com.sofkau.Library.mappers.ResourceMapper;
import com.sofkau.Library.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteResourceUseCase implements DeleteResource{
    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    @Autowired
    public DeleteResourceUseCase(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }


    @Override
    public Mono<Void> delete(String id) {
        return resourceRepository.deleteById(id);
    }
}
