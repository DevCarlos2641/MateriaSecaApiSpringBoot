package com.example.materia_seca.model;

import com.example.materia_seca.entity.SampleField;
import com.example.materia_seca.entity.SampleWeight;
import lombok.Data;

@Data
public class RequestSampleField {

    private SampleWeight[] pesos;
    private SampleField muestra;
}
