package com.sofkau.Library.controllers;

import com.sofkau.Library.dtos.ResourceDTO;
import com.sofkau.Library.dtos.StatusDTO;
import com.sofkau.Library.services.RecommendationResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resources")
public class RecommendationResourceController {
    @Autowired
    RecommendationResourceService recommendationResourceService;

    @GetMapping("/recommendation/type/{type}")
    public ResponseEntity<ResourceDTO> recommendResourcesByType (@PathVariable("type") String type) {
        try {
            return new ResponseEntity(recommendationResourceService.recommendResourcesByType(type), HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/recommendation/area/{area}")
    public ResponseEntity<ResourceDTO> recommendResourcesByArea (@PathVariable("area") String area) {
        try {
            return new ResponseEntity(recommendationResourceService.recommendResourcesByArea(area), HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
