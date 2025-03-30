package com.example.materia_seca.controller;

import com.example.materia_seca.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tool")
public class ToolController {

    @Autowired
    private ToolService service;

    @GetMapping("/{id_junta_local}")
    public ResponseEntity<?> getTools (@PathVariable int id_junta_local){
        return service.getToolsByIdJunta(id_junta_local);
    }
}
