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
@Table(name = "opciones_muestras")
public class SampleOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_opciones_muestras;

    private int cantidad;
}
