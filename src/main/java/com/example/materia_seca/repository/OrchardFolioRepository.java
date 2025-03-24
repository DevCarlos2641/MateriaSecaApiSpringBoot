package com.example.materia_seca.repository;

import com.example.materia_seca.entity.OrchardFolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrchardFolioRepository extends JpaRepository<OrchardFolio, Long> {

    @NativeQuery("SELECT * FROM huerta_foliada WHERE id_folio = :folio")
    OrchardFolio getOrchardFolioByFolio(String folio);
}
