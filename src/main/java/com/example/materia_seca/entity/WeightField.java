package com.example.materia_seca.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "peso_campo")
public class WeightField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_peso_campo;

    @Column(length = 50)
    private String id_folio;

    @Column(precision = 10, scale = 4)
    private BigDecimal muestra;

    @Column(length = 25)
    private String cordenada;

    private String url_image;

    private String observaciones;
}
