package com.example.materia_seca.repository;

import com.example.materia_seca.entity.SampleField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleFieldRepository extends JpaRepository<SampleField, String> {

}
