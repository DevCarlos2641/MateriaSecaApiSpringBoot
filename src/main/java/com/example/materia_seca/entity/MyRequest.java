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
@Table(name = "solicitud")
public class MyRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_solicitud;

    @OneToOne
    @JoinColumn(name = "id_hue", referencedColumnName = "id_hue")
    private Orchard huerta;

    @Column(length = 30)
    //  Foreign key
    private String id_folio;

    @OneToOne
    @JoinColumn(name = "id_tecnico", referencedColumnName = "id_tecnico")
    private Technical technical;

    //  Foreign Key
    @OneToOne
    @JoinColumn(name = "id_opciones_muestras", referencedColumnName =  "id_opciones_muestras")
    private SampleOptions options;

    @Column(length = 20)
    private String status;

    private String fecha_programada;

    @Column(length = 255)
    private String motivo_cancelacion;

    @Column(length = 11)
    private String tipo;

    private int rango;

    @Column(length = 20)
    private String floracion;

    private String fecha_fin;
}
