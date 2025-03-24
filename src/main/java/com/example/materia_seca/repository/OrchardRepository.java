package com.example.materia_seca.repository;

import com.example.materia_seca.entity.Orchard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrchardRepository extends JpaRepository<Orchard, Long> {

    @NativeQuery("SELECT * FROM huerta WHERE id_hue = :hue")
    Orchard getOrchardByHue(String hue);

}
