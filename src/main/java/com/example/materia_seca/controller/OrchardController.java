package com.example.materia_seca.controller;

import com.example.materia_seca.model.RequestGetUrls;
import com.example.materia_seca.service.OrchardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orchard")
public class OrchardController {

    @Autowired
    private OrchardService service;

    @GetMapping("/urls-kml")
    public ResponseEntity<?> getUrlsKml(@RequestBody RequestGetUrls request){
        return service.getUrlsKml(request);
    }

    @GetMapping("/{id_solicitud}/{tipo}")
    public ResponseEntity<?> getOrchard(@PathVariable int id_solicitud, @PathVariable String tipo){
        return service.getOrchardForLaboratory(id_solicitud, tipo);
    }

}
