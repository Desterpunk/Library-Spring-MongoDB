package com.sofkau.Library.services;

import com.sofkau.Library.dtos.ResourceDTO;
import com.sofkau.Library.mappers.ResourceMapper;
import com.sofkau.Library.models.Resource;
import com.sofkau.Library.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {
    @Autowired
    ResourceRepository resourceRepository;
    ResourceMapper mapper = new ResourceMapper();

    public List<ResourceDTO> findAll() {
        List<Resource> resources = resourceRepository.findAll();
        return mapper.fromCollectionList(resources);
    }

    public ResourceDTO findById(String id) throws Throwable {
        Resource resource = (Resource) resourceRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no resource with that ID"));
        return mapper.fromCollection(resource);
    }

    public ResourceDTO save(ResourceDTO resourceDTO){
        Resource resource = mapper.fromDTO(resourceDTO);
        return mapper.fromCollection((Resource) resourceRepository.save(resource));
    }

    public ResourceDTO update(ResourceDTO resourceDTO) throws Throwable {
        Resource resource = mapper.fromDTO(resourceDTO);
        resourceRepository.findById(resource.getId()).orElseThrow(() -> new RuntimeException("There is no resource with that ID"));
        return mapper.fromCollection((Resource) resourceRepository.save(resource));
    }

    public void delete(String id) {
        resourceRepository.deleteById(id);
    }
}
