package com.example.materia_seca.repository;

import com.example.materia_seca.entity.Technical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalRepository extends JpaRepository<Technical, Long> {

    @NativeQuery("SELECT * FROM tecnico WHERE id_usuario = :id")
    Technical getTechnicalByIdUser(int id);

}
