package com.example.materia_seca.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "muestra_laboratorio")
public class SampleLaboratory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_muestra_laboratorio;

    @Column(length = 50)
    private String id_folio;

    @Column(length = 40)
    private String fecha_inicio;

    @Column(length = 40)
    private String fecha_final;

    private int id_usuario;

    private String observaciones;

    private String url_reporte;

    @Column(precision = 10, scale = 4)
    private BigDecimal promedio;

    @Column(precision = 10, scale = 4)
    private BigDecimal desv_estandar;

    @Column(precision = 10, scale = 4)
    private BigDecimal porcentaje_cv;

    private int id_bascula;

    private int id_microondas;
}
