package com.example.materia_seca.repository;

import com.example.materia_seca.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {

    @NativeQuery("SELECT * FROM herramienta WHERE id_junta_local = :id")
    Tool[] getToolsByIdJunta(int id);

}
