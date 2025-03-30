package com.example.materia_seca.repository;

import com.example.materia_seca.entity.WeightField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightFieldRepository extends JpaRepository<WeightField, Long> {
}
