package com.sofkau.Library.usecases;

import com.sofkau.Library.dtos.ResourceDTO;
import com.sofkau.Library.mappers.ResourceMapper;
import com.sofkau.Library.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UpdateResourceUseCase implements UpdateResource{
    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    @Autowired
    public UpdateResourceUseCase(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public Mono<ResourceDTO> apply(ResourceDTO resourceDTO){
        return resourceRepository.save(resourceMapper.mapperToResource(resourceDTO.getId()).apply(resourceDTO)).map(resourceMapper.mapEntityToDTO());
    }
}
