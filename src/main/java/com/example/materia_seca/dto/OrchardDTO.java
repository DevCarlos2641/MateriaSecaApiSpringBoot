package com.example.materia_seca.dto;

import lombok.Data;
import java.sql.Date;

@Data
public class OrchardDTO {

    private String id;

    private int id_productor;

    private String nombre;

    private String localidad;

    private String centroide;

    private Double hectareas;

    private int pronostico_de_cosecha;

    private Double longitud;

    private Double altura_nivel_del_mar;

    private String variedad;

    private int anoplantacion;

    private int arbolesporhectareas;

    private String etapafenologica;

    private String fechasv_01;

    private String fechasv_02;

    private String rutaKML;

    private Date fecha_registro;

    private int id_junta_local;

    private Double latitud;
}
