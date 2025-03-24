package com.example.materia_seca.controller;

import com.example.materia_seca.model.CancelRequest;
import com.example.materia_seca.service.MyRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myRequest")
public class MyRequestController {

    @Autowired
    private MyRequestService service;

    @PostMapping("/cancel")
    public ResponseEntity<?> cancelRequest(@RequestBody CancelRequest cancelRequest){
        return service.cancelRequest(cancelRequest);
    }
}
