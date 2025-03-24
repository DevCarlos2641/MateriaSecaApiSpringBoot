package com.example.materia_seca.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "huerta_foliada")
public class OrchardFolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 30)
    private String id_folio;

    //  Foreign Key
    private int id_productor;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private String localidad;

    @Column(length = 30)
    private String centroide;

    private Double hectareas;

    private int pronostico_de_cosecha;

    private Double longitud;

    private Double altura_nivel_del_mar;

    @Column(length = 20)
    private String variedad;

    private int anoplantacion;

    private int arbolesporhectareas;

    @Column(length = 50)
    private String etapafenologica;

    private String fechasv_01;

    private String fechasv_02;

    @Column(length = 255)
    private String rutaKML;

    @Column(name = "fecha_registro")
    private Date fecha_registro;

    private int id_junta_local;

    @Column(length = 20)
    private String status;

    private Double latitud;

}
