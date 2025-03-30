package com.example.materia_seca.repository;

import com.example.materia_seca.entity.SampleLaboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleLaboratoryRepository extends JpaRepository<SampleLaboratory, Integer> {

    @NativeQuery("SELECT * FROM muestra_laboratorio WHERE id_folio = :folio")
    SampleLaboratory getSampleByFolio(String folio);

}
