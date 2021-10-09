package com.sofkau.Library.services;

import com.sofkau.Library.dtos.ResourceDTO;
import com.sofkau.Library.models.Resource;
import com.sofkau.Library.repositories.ResourceRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class ResourceServiceTest {

    @MockBean
    private ResourceRepository resourceRepository;

    @Autowired
    private ResourceService resourceService;

    @Test
    @DisplayName("Test FindAll Success")
    public void getAll() {
        var data1 = new Resource();
        data1.setId("1");
        data1.setName("Moby-Dick");
        data1.setType("Libro");
        data1.setArea("Entretenimiento");
        data1.setDate(LocalDate.now());
        data1.setAvaible(true);
        var data2 = new Resource();
        data2.setId("2");
        data2.setName("El gen egoista");
        data2.setType("Libro");
        data2.setArea("Ciencia");
        data2.setDate(LocalDate.now());
        data2.setAvaible(false);

        doReturn(Lists.newArrayList(data1,data2)).when(resourceRepository).findAll();

        var result = resourceService.findAll();

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(data1.getName(), result.get(0).getName());
        Assertions.assertEquals(data2.getName(), result.get(1).getName());
    }

    @Test
    @DisplayName("Test save Success")
    public void save() {

        var data1 = new Resource();
        data1.setId("1");
        data1.setName("Moby-Dick");
        data1.setType("Libro");
        data1.setArea("Entretenimiento");
        data1.setDate(LocalDate.now());
        data1.setAvaible(true);

        var data2 = new ResourceDTO();
        data2.setName("Moby-Dick");
        data2.setType("Libro");
        data2.setArea("Entretenimiento");
        data2.setDate(LocalDate.now());
        data2.setAvaible(true);

        doReturn(data1).when(resourceRepository).save(any());

        var result = resourceService.save(data2);

        Assertions.assertNotNull(result, "el valor guardado no debe ser nulo");

        Assertions.assertEquals(data1.getName(), result.getName(), "el nombre no corresponde");
        Assertions.assertEquals(data1.getType(), result.getType(), "el tipo no corresponde");
    }
}