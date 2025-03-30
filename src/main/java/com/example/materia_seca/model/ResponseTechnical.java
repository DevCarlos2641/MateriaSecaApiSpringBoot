package com.example.materia_seca.model;

import com.example.materia_seca.dto.MyRequestDTO;
import com.example.materia_seca.dto.OrchardDTO;
import com.example.materia_seca.dto.TechnicalDTO;
import com.example.materia_seca.dto.UserDTO;
import com.example.materia_seca.entity.*;
import lombok.Data;

import java.util.List;

@Data
public class ResponseTechnical {
    private String status;
    private UserDTO usuario;
    private TechnicalDTO tecnico;
    private List<MyRequestDTO> solicitudes;
    private List<OrchardDTO> Huertas;
    private List<LocalBoard> juntas;
}
