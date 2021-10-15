package com.sofkau.Library.mappers;

import com.sofkau.Library.dtos.StatusDTO;
import com.sofkau.Library.models.Resource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.function.Function;

@Component
public class StatusMapper {

    public Function<Resource, StatusDTO> mapperToStatus(){
        return updateResource -> {
            var status = new StatusDTO();
            if (updateResource.getAvaible()){
                status.setStatus(" Resource is available ");
                status.setAvailable(updateResource.getAvaible());
                status.setDate(updateResource.getDate());
                return status;
            }
            status.setStatus( "Resource is not available");
            status.setAvailable(updateResource.getAvaible());
            status.setDate(updateResource.getDate());
            return status;
        };
    }
    public Function<Resource, StatusDTO> mapperMessageResourceLoan(){
        return updateResource-> {
            LocalDate localDate = LocalDate.now();
            var status = new StatusDTO();
            if (updateResource.getAvaible()){
                status.setStatus("El recurso fue prestado exitosamente");
                status.setAvailable(false);
                status.setDate(localDate);
                return status;
            }
            status.setStatus("El recurso no esta disponible para prestar");
            status.setAvailable(updateResource.getAvaible());
            status.setDate(updateResource.getDate());
            return status;
        };
    }
}