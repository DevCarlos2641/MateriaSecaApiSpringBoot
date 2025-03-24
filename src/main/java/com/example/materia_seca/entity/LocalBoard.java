package com.example.materia_seca.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "junta_local")
public class LocalBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_junta_local;

    private int id_usuario;

    @Column(length = 255)
    private String carga_municipios;

    @Column(length = 100)
    private String nombre;

    @Column(length = 100)
    private String domicilio;

    @Column(length = 50)
    private String telefono;

    @Column(length = 50)
    private String correo;

    @Column(length = 10)
    private String estatus;

    @Column(length = 255)
    private String ruta_img;

}
