package com.sofkau.Library.usecases;

import com.sofkau.Library.dtos.StatusDTO;
import com.sofkau.Library.mappers.StatusMapper;
import com.sofkau.Library.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class AvailabilityResourceUseCase implements AvailabilityResource {
    private final ResourceRepository resourceRepository;
    private final StatusMapper statusMapper;

    @Autowired
    public AvailabilityResourceUseCase(ResourceRepository resourceRepository, StatusMapper statusMapper) {
        this.resourceRepository = resourceRepository;
        this.statusMapper = statusMapper;
    }

    @Override
    public Mono<StatusDTO> apply(String id) {
        return resourceRepository.findById(id).map(statusMapper.mapperToStatus());
    }
}
