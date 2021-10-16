package com.sofkau.Library.usecases;

import com.sofkau.Library.models.Resource;
import com.sofkau.Library.repositories.ResourceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ListResourceUseCaseTest {
    @SpyBean
    private ListResourceUseCase listResourceUseCase;

    @MockBean
    private ResourceRepository resourceRepository;

    @Test
    public void useCaseListRecursoTest(){

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

        when(resourceRepository.findAll()).thenReturn(Flux.just(resource1,resource2));

        var answer = listResourceUseCase.get();

        Assertions.assertEquals(answer.blockFirst().getAvaible(),true);
        Assertions.assertEquals(answer.blockFirst().getType(),"libro");
        Assertions.assertEquals(answer.blockLast().getName(),"historias de terror");
    }
}