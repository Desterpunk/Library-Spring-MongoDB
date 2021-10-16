package com.sofkau.Library.usecases;

import com.sofkau.Library.dtos.ResourceDTO;
import com.sofkau.Library.mappers.ResourceMapper;
import com.sofkau.Library.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class FindResourceByTypeAndAreaUseCase implements FindResourceByTypeAndArea {
    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    @Autowired
    public FindResourceByTypeAndAreaUseCase(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public Flux<ResourceDTO> apply(String type, String area) {
        return resourceRepository.findResourcesByTypeAndArea(type,area).map(resourceMapper.mapEntityToDTO());
    }
}