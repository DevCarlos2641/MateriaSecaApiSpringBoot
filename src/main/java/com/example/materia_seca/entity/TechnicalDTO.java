package com.example.materia_seca.entity;

import lombok.Data;

@Data
public class TechnicalDTO {

    private int id_tecnico;

    private int id_usuario;

    private int idjuntaLocal;

    private String carga_municipios;

    private String estatus;
}
