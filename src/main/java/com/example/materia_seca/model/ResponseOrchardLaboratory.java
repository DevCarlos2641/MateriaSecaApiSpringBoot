package com.example.materia_seca.model;

import com.example.materia_seca.dto.MyRequestDTO;
import com.example.materia_seca.dto.OrchardDTO;
import lombok.Data;

@Data
public class ResponseOrchardLaboratory {
    private OrchardDTO orchard;
    private MyRequestDTO request;
}
