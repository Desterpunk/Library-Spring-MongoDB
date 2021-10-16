package com.sofkau.Library.routers;

import com.sofkau.Library.dtos.ResourceDTO;
import com.sofkau.Library.mappers.ResourceMapper;
import com.sofkau.Library.models.Resource;
import com.sofkau.Library.repositories.ResourceRepository;
import com.sofkau.Library.usecases.ListResourceUseCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ListResourceRouter.class, ListResourceUseCase.class, ResourceMapper.class})
class ListResourceRouterTest {
    @MockBean
    private ResourceRepository resourceRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testGetAllResources() {
        Resource resource1 = new Resource();
        resource1.setId("1");
        resource1.setName("historias de terror");
        resource1.setType("libro");
        resource1.setDate(LocalDate.now());
        resource1.setAvaible(true);
        resource1.setArea("Entretenimiento");

        Resource resource2 = new Resource();
        resource2.setId("1");
        resource2.setName("historias de terror");
        resource2.setType("libro");
        resource2.setDate(LocalDate.now());
        resource2.setAvaible(true);
        resource2.setArea("Entretenimiento");

        when(resourceRepository.findAll()).thenReturn(Flux.just(resource1, resource2));

        webTestClient.get()
                .uri("/library")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ResourceDTO.class)
                .value(userResponse -> {
                            Assertions.assertThat(userResponse.get(0).getArea()).isEqualTo(resource1.getArea());
                            Assertions.assertThat(userResponse.get(1).getArea()).isEqualTo(resource2.getArea());
                        }
                );
    }

}