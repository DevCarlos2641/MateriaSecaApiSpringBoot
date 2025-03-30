package com.example.materia_seca.model;

import com.example.materia_seca.dto.UserDTO;
import lombok.Data;

@Data
public class ResponseLaboratory {

    private String status;

    private UserDTO usuario;

}
