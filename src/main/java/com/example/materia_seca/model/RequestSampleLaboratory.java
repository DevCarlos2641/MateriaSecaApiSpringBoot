package com.example.materia_seca.model;

import com.example.materia_seca.entity.SampleLaboratory;
import com.example.materia_seca.entity.WeightLaboratory;
import lombok.Data;

@Data
public class RequestSampleLaboratory {

    private SampleLaboratory sample;

    private WeightLaboratory[] weights;

    private int id_solicitud;

    private String newFolio;
}
