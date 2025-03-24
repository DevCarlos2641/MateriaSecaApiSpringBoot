package com.example.materia_seca.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "herramienta")
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_herramienta;

    private String tipo;

    @Column(length = 20)
    private String marca;

    @Column(length = 20)
    private String modelo;

    @Column(length = 50)
    private String descripcion;

    private String fecha_adquisicion;

    private String fecha_mantenimiento;

    private int id_junta_local;
}
