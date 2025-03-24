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
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;

    @OneToOne
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo") // Llave foránea
    private UserType userType;

    private String nombre;

    private String correo;

    private String telefono;

    private String password;

}
