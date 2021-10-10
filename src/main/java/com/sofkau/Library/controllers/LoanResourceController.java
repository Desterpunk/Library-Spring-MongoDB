package com.sofkau.Library.controllers;

import com.sofkau.Library.dtos.StatusDTO;
import com.sofkau.Library.services.LoanResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resources")

public class LoanResourceController {
    @Autowired
    LoanResourceService loanResourceService;

    @GetMapping("/loan/{id}")
    public ResponseEntity<StatusDTO> loanResource (@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(loanResourceService.loanResource(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/return/{id}")
    public ResponseEntity<StatusDTO> returnResource (@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(loanResourceService.returnResource(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
