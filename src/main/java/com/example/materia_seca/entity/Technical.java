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
@Table (name = "tecnico")
public class Technical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tecnico;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private User user;

    @OneToOne
    @JoinColumn(name = "id_junta_local", referencedColumnName = "id_junta_local")
    private LocalBoard junta;

    @Column(length = 500)
    private String carga_municipios;

    @Column(length = 20)
    private String estatus;
}
