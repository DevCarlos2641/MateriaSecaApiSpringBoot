package com.example.materia_seca.repository;

import com.example.materia_seca.entity.MyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRequestRepository extends JpaRepository<MyRequest, Long> {

    @NativeQuery("SELECT * FROM solicitud WHERE id_solicitud = :id")
    MyRequest getRequest(int id);

    @NativeQuery("SELECT * FROM solicitud WHERE id_tecnico = :id")
    MyRequest[] getRequestByIdTechnical(int id);

    @NativeQuery("SELECT * FROM solicitud WHERE id_solicitud = :id AND tipo = :type")
    MyRequest getRequestByIdAndType(int id, String type);
}
