package com.sofkau.Library.usecases;

import com.sofkau.Library.dtos.ResourceDTO;
import com.sofkau.Library.models.Resource;
import com.sofkau.Library.repositories.ResourceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreateResourceUseCaseTest {

    @SpyBean
    private CreateResourceUseCase createResourceUseCase;

    @MockBean
    private ResourceRepository resourceRepository;

    @DisplayName("test create resource")
    @Test
    public void createResourceUseCaseTest() {
        ResourceDTO resourceDTO = new ResourceDTO();
        resourceDTO.setName("historias de terror");
        resourceDTO.setType("libro");
        resourceDTO.setDate(LocalDate.now());
        resourceDTO.setAvaible(true);
        resourceDTO.setArea("diversion");

        Resource resource = new Resource();
        resource.setName("historias de terror");
        resource.setType("libro");
        resource.setDate(LocalDate.now());
        resource.setAvaible(true);
        resource.setArea("diversion");

        when(resourceRepository.save(Mockito.any(Resource.class))).thenReturn(Mono.just(resource));

        var answer = createResourceUseCase.apply(resourceDTO);

        Assertions.assertEquals(answer.block().getName(), "historias de terror");
        Assertions.assertEquals(answer.block().getAvaible(), true);
    }

}