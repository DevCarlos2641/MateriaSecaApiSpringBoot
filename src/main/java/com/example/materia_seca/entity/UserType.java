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
@Table(name = "tipo_usuario")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo;

    @Column(length = 25)
    private String descripcion;
}
