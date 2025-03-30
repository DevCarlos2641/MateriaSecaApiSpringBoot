package com.example.materia_seca.dto;

import lombok.Data;

@Data
public class UserDTO {

    private int id_usuario;

    private int id_tipo;

    private String nombre;

    private String correo;

    private String telefono;

    private String contraseña;
}