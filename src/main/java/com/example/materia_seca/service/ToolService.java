package com.example.materia_seca.service;

import com.example.materia_seca.entity.Tool;
import com.example.materia_seca.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ToolService {

    @Autowired
    private ToolRepository repository;

    public ResponseEntity<?> getToolsByIdJunta(int id) {
        return ResponseEntity.ok(repository.getToolsByIdJunta(id));
    }
}
