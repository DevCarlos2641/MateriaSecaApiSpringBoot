package com.example.materia_seca.dto;

import lombok.Data;

@Data
public class MyRequestDTO {

    private int id_solicitud;

    private String id_hue;

    private String id_folio;

    private int id_tecnico;

    private int cantidad;

    private String status;

    private String fecha_programada;

    private String motivo_cancelacion;

    private String tipo;

    private int rango;

    private String floracion;

    private String fecha_fin;
}
