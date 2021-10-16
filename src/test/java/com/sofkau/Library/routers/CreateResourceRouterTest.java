package com.sofkau.Library.routers;

import com.sofkau.Library.dtos.ResourceDTO;
import com.sofkau.Library.mappers.ResourceMapper;
import com.sofkau.Library.models.Resource;
import com.sofkau.Library.repositories.ResourceRepository;
import com.sofkau.Library.usecases.CreateResourceUseCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CreateResourceRouter.class, CreateResourceUseCase.class, ResourceMapper.class})
class CreateResourceRouterTest {
    @MockBean
    private ResourceRepository resourceRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testCreateResource() {

        Resource resource = new Resource();
        resource.setId("1");
        resource.setName("historias de terror");
        resource.setType("libro");
        resource.setDate(LocalDate.now());
        resource.setAvaible(true);
        resource.setArea("Entretenimiento");

        ResourceDTO resourceDTO = new ResourceDTO(resource.getId(),resource.getName(),resource.getType(),resource.getArea(),resource.getDate(),resource.getAvaible());
        Mono<Resource> mono = Mono.just(resource);
        when(resourceRepository.save(any())).thenReturn(mono);

        webTestClient.post()
                .uri("/library")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(resourceDTO), ResourceDTO.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(ResourceDTO.class)
                .value(userResponse -> {
                            Assertions.assertThat(userResponse.getId()).isEqualTo(resource.getId());
                        }
                );
    }
}