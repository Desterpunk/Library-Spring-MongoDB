package com.sofkau.Library.services;

import com.sofkau.Library.dtos.ResourceDTO;
import com.sofkau.Library.mappers.ResourceMapper;
import com.sofkau.Library.models.Resource;
import com.sofkau.Library.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationResourceService {

    @Autowired
    ResourceRepository resourceRepository;
    ResourceMapper resourceMapper = new ResourceMapper();

    public List<ResourceDTO> recommendResourcesByType(String type){
        List<Resource> resources = resourceRepository.findResourcesByType(type).orElseThrow(() -> new RuntimeException("There is no resource with that type"));
        return resourceMapper.fromCollectionList(resources);
    }

    public List<ResourceDTO> recommendResourcesByArea(String area){
        List<Resource> resources = resourceRepository.findResourcesByArea(area).orElseThrow(() -> new RuntimeException("There is no resource with that area"));
        return resourceMapper.fromCollectionList(resources);
    }

    public List<ResourceDTO> recommendResourcesByTypeAndArea(String type, String area){
        List<Resource> resources = resourceRepository.findResourcesByTypeAndArea(type,area).orElseThrow(() -> new RuntimeException("There is no resource with that type and area"));
        return resourceMapper.fromCollectionList(resources);
    }
}
