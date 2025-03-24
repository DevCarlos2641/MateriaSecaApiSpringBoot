package com.example.materia_seca.repository;

import com.example.materia_seca.entity.LocalBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalBroadRepository extends JpaRepository<LocalBoard, Long> {

    @NativeQuery("SELECT * FROM junta_local WHERE id_junta_local = :id")
    LocalBoard getLocalBoardById(int id);

}
