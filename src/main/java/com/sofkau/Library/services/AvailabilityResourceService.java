package com.sofkau.Library.services;

import com.sofkau.Library.dtos.StatusDTO;
import com.sofkau.Library.mappers.ResourceMapper;
import com.sofkau.Library.models.Resource;
import com.sofkau.Library.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityResourceService {

    @Autowired
    ResourceRepository resourceRepository;

    public StatusDTO avaible (String id){
        StatusDTO statusDTO = new StatusDTO();

        ResourceMapper resourceMapper = new ResourceMapper();

        Resource resource = resourceRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no resource with that ID"));
        if (resource.getAvaible()){
            statusDTO.setStatus(resourceMapper.fromCollection(resource).getName() + " is avaible");
            statusDTO.setAvaible(true);
            statusDTO.setDate(null);
            return statusDTO;
        }
        statusDTO.setStatus(resourceMapper.fromCollection(resource).getName() + " is not avaible");
        statusDTO.setAvaible(false);
        statusDTO.setDate(resourceMapper.fromCollection(resource).getDate());
        return statusDTO;
    }

}
