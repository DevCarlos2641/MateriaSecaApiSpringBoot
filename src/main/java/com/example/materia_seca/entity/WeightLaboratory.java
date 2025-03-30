package com.example.materia_seca.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "peso_laboratorio")
public class WeightLaboratory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_peso_laboratorio;

    private int id_muestra_laboratorio;

    @Column(length = 50)
    private String id_folio;

    @Column(precision = 10, scale = 4)
    private BigDecimal muestra;

    @Column(precision = 10, scale = 4)
    private BigDecimal papel;

    @Column(precision = 10, scale = 4)
    private BigDecimal pulpa;

    @Column(precision = 10, scale = 4)
    private BigDecimal muestra_seca;

    @Column(precision = 10, scale = 4)
    private BigDecimal humedad;

    @Column(precision = 10, scale = 4)
    private BigDecimal neto;

    @Column(precision = 10, scale = 4)
    private BigDecimal porcentaje;

}
