package com.example.materia_seca.model;

import com.example.materia_seca.entity.SampleField;
import com.example.materia_seca.entity.WeightField;
import lombok.Data;

@Data
public class RequestSampleField {

    private WeightField[] pesos;
    private SampleField muestra;
}
