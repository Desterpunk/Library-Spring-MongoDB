package com.sofkau.Library.controllers;

import com.sofkau.Library.dtos.StatusDTO;
import com.sofkau.Library.services.AvailabilityResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resources")

public class AvailabilityResourceController {
    @Autowired
    AvailabilityResourceService availabilityResourceService;

    @GetMapping("/availability/{id}")
    public ResponseEntity<StatusDTO> availability(@PathVariable("id") String id){
        return new ResponseEntity<>(availabilityResourceService.avaible(id) , HttpStatus.OK);
    }
}
