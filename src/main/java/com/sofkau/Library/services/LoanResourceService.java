package com.sofkau.Library.services;

import com.sofkau.Library.dtos.StatusDTO;
import com.sofkau.Library.mappers.ResourceMapper;
import com.sofkau.Library.models.Resource;
import com.sofkau.Library.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoanResourceService {

    @Autowired
    ResourceRepository resourceRepository;

    ResourceMapper resourceMapper = new ResourceMapper();

    public StatusDTO loanResource(String id){
        StatusDTO statusDTO = new StatusDTO();

        Resource resource = resourceRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no resource with that ID"));
        if (resource.getAvaible()){
            resource.setAvaible(false);
            resource.setDate(LocalDate.now());
            resourceRepository.save(resource);
            statusDTO.setStatus(resourceMapper.fromCollection(resource).getName() + " was successfully loaned");
            statusDTO.setAvailable(false);
            statusDTO.setDate(resourceMapper.fromCollection(resource).getDate());
            return statusDTO;
        }
        statusDTO.setStatus(resourceMapper.fromCollection(resource).getName() + " is not available");
        statusDTO.setAvailable(resourceMapper.fromCollection(resource).getAvaible());
        statusDTO.setDate(resourceMapper.fromCollection(resource).getDate());
        return statusDTO;
    }

    public StatusDTO returnResource(String id){
        StatusDTO statusDTO = new StatusDTO();

        Resource resource = resourceRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no resource with that ID"));
        if (!resource.getAvaible()){
            resource.setAvaible(true);
            resource.setDate(LocalDate.now());
            resourceRepository.save(resource);
            statusDTO.setStatus(resourceMapper.fromCollection(resource).getName() + " was successfully returned");
            statusDTO.setAvailable(resourceMapper.fromCollection(resource).getAvaible());
            statusDTO.setDate(resourceMapper.fromCollection(resource).getDate());
            return statusDTO;
        }
        statusDTO.setStatus(resourceMapper.fromCollection(resource).getName() + " is actually returned");
        statusDTO.setAvailable(true);
        statusDTO.setDate(resourceMapper.fromCollection(resource).getDate());
        return statusDTO;
    }
}
