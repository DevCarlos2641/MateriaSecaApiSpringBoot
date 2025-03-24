package com.example.materia_seca.repository;

import com.example.materia_seca.entity.SampleWeight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleWeightRepository extends JpaRepository<SampleWeight, Long> {
}
