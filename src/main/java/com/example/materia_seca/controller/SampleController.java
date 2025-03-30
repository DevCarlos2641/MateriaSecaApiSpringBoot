package com.example.materia_seca.controller;

import com.example.materia_seca.model.RequestSampleField;
import com.example.materia_seca.model.RequestSampleLaboratory;
import com.example.materia_seca.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    private SampleService service;

    @PostMapping("/upload-images")
    public ResponseEntity<?> uploadsImagesSamples(@RequestPart("images") MultipartFile[] files){
        return service.uploadImages(files);
    }

    @PostMapping
    public ResponseEntity<?> postSamples(@RequestBody RequestSampleField sampleField){
        return service.uploadSamplesField(sampleField);
    }

    @PostMapping("/laboratory")
    public ResponseEntity<?> postSampleLaboratory(@RequestBody RequestSampleLaboratory sampleLaboratory){
        return service.uploadSampleLaboratory(sampleLaboratory);
    }


}
