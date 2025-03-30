package com.example.materia_seca.repository;

import com.example.materia_seca.entity.WeightLaboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightLaboratoryRepository extends JpaRepository<WeightLaboratory, Integer> {

}
