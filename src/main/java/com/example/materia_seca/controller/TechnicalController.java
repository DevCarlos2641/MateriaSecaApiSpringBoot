package com.example.materia_seca.controller;

import com.example.materia_seca.service.MyRequestService;
import com.example.materia_seca.service.TechnicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/technical")
public class TechnicalController {

    @Autowired
    private TechnicalService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> getMyRequests(@PathVariable int id){
        return service.getMyRequestByIdTechnical(id);
    }
}
