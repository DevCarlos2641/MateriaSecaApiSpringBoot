package com.example.materia_seca.model;

import com.example.materia_seca.entity.LocalBoard;
import com.example.materia_seca.dto.MyRequestDTO;
import com.example.materia_seca.dto.OrchardDTO;
import lombok.Data;

import java.util.List;

@Data
public class ResponseMyRequests {

    private List<MyRequestDTO> solicitudes;

    private List<OrchardDTO> huertas;

    private List<LocalBoard> juntas;

}
