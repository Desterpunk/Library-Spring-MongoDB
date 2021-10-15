package com.sofkau.Library.usecases;

import com.sofkau.Library.dtos.ResourceDTO;
import com.sofkau.Library.mappers.ResourceMapper;
import com.sofkau.Library.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GetResourceUseCase implements GetResource{
    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    @Autowired
    public GetResourceUseCase(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public Mono<ResourceDTO> findById(String id) {
        return resourceRepository.findById(id).map(resourceMapper.mapEntityToDTO());
    }
}
