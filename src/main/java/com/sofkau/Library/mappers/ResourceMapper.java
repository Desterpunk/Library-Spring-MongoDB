package com.sofkau.Library.mappers;

import com.sofkau.Library.dtos.ResourceDTO;
import com.sofkau.Library.models.Resource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.function.Function;

@Component
public class ResourceMapper {

    public Function<ResourceDTO, Resource> mapperToResource(String id){
        return updateResource -> {
            var resource = new Resource();
            resource.setId(id);
            resource.setName(updateResource.getName());
            resource.setType(updateResource.getType());
            resource.setArea(updateResource.getArea());
            resource.setDate(updateResource.getDate());
            resource.setAvaible(updateResource.getAvaible());

            return resource;
        };
    }

    public Function<Resource,ResourceDTO> mapEntityToDTO() {
        return entity -> new ResourceDTO(entity.getId(),entity.getName(), entity.getType(),entity.getArea(),entity.getDate(),entity.getAvaible());
    }
}
