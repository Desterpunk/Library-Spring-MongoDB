package com.sofkau.Library.controllers;

import com.sofkau.Library.dtos.ResourceDTO;
import com.sofkau.Library.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourceController {
    @Autowired
    ResourceService resourceService;

    @GetMapping("/{id}")
    public ResponseEntity<ResourceDTO> findById(@PathVariable("id") String id) throws Throwable {
        return new ResponseEntity(resourceService.findById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ResourceDTO>> findAll() {
        return new ResponseEntity(resourceService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ResourceDTO> create(@RequestBody ResourceDTO resourceDTO) {
        return new ResponseEntity(resourceService.save(resourceDTO), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<ResourceDTO> update(@RequestBody ResourceDTO resourceDTO) throws Throwable {
        if (resourceDTO.getId() != null) {
            return new ResponseEntity(resourceService.update(resourceDTO), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        try {
            resourceService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
