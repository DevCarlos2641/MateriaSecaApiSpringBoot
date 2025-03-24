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
@Table(name = "muestra_campo")
public class SampleField {

    @Id
    @Column(length = 50)
    private String id_folio;

    @Column(length = 30)
    private String tipo_muestreo;

    @Column(length = 30)
    private String fecha;

    private String qr_image;

    private int id_solicitud;

}
