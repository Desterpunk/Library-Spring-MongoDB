package com.sofkau.Library.mappers;

import com.sofkau.Library.dtos.ResourceDTO;
import com.sofkau.Library.models.Resource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResourceMapper {
    public Resource fromDTO(ResourceDTO resourceDTO){
        Resource resource = new Resource();
        resource.setId(resourceDTO.getId());
        resource.setName(resourceDTO.getName());
        resource.setType(resourceDTO.getType());
        resource.setArea(resourceDTO.getArea());
        resource.setDate(resourceDTO.getDate());
        resource.setAvaible(resourceDTO.getAvaible());
        return resource;
    }

    public ResourceDTO fromCollection(Resource resource){
        ResourceDTO resourceDTO= new ResourceDTO();
        resourceDTO.setId(resource.getId());
        resourceDTO.setName(resource.getName());
        resourceDTO.setType(resource.getType());
        resourceDTO.setArea(resource.getArea());
        resourceDTO.setDate(resource.getDate());
        resourceDTO.setAvaible(resource.getAvaible());
        return resourceDTO;
    }

    public List<ResourceDTO> fromCollectionList(List<Resource> resources){
        if (resources == null){
            return null;
        }
        List<ResourceDTO> resourcesDTO = new ArrayList<>(resources.size());
        Iterator listTracks = resources.iterator();

        while (listTracks.hasNext()) {
            Resource resource = (Resource) listTracks.next();
            resourcesDTO.add(fromCollection(resource));
        }

        return resourcesDTO;
    }

}
