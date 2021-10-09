package com.sofkau.Library.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sofkau.Library.dtos.ResourceDTO;
import com.sofkau.Library.models.Resource;
import com.sofkau.Library.services.ResourceService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ResourceControllerTest {

    @MockBean
    private ResourceService resourceService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /resources success")
    public void findAll() throws Exception {
        //setup mock service
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

        doReturn(Lists.newArrayList(data1,data2)).when(resourceService).findAll();

        //execute Get request
        mockMvc.perform(get("/resources"))
                // Validate the response code and content type
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                // Validate the returned fields
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is("1")))
                .andExpect(jsonPath("$[0].name", is("Moby-Dick")))
                .andExpect(jsonPath("$[0].type", is("Libro")))
                .andExpect(jsonPath("$[1].id", is("2")))
                .andExpect(jsonPath("$[1].name", is("El gen egoista")))
                .andExpect(jsonPath("$[1].type", is("Libro")));
    }

    @Test
    @DisplayName("POST /resources success")
    public void create() throws Exception {
        // Setup our mocked service
        ResourceDTO dataPost = new ResourceDTO();
        dataPost.setId("1");
        dataPost.setName("Moby-Dick");
        dataPost.setType("Libro");
        dataPost.setArea("Entretenimiento");
        dataPost.setAvaible(true);

        ResourceDTO dataReturn = new ResourceDTO();
        dataReturn.setId("1");
        dataReturn.setName("Moby-Dick");
        dataReturn.setType("Libro");
        dataReturn.setArea("Entretenimiento");
        dataReturn.setAvaible(true);

        doReturn(dataReturn).when(resourceService).save(any());

        // Execute the POST request
        mockMvc.perform(post("/resources")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(dataPost)))

                // Validate the response code and content type
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                // Validate the returned fields
                .andExpect(jsonPath("$.id", is("1")))
                .andExpect(jsonPath("$.name", is("Moby-Dick")))
                .andExpect(jsonPath("$.type", is("Libro")));
    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}