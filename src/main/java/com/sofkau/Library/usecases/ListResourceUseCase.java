package com.sofkau.Library.usecases;

import com.sofkau.Library.dtos.ResourceDTO;
import com.sofkau.Library.mappers.ResourceMapper;
import com.sofkau.Library.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
public class ListResourceUseCase implements Supplier<Flux<ResourceDTO>> {
    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    @Autowired
    public ListResourceUseCase(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public Flux<ResourceDTO> get() {
        return resourceRepository.findAll().map(resourceMapper.mapEntityToDTO());
    }
}
