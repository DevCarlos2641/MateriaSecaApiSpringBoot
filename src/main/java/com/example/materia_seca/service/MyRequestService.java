package com.example.materia_seca.service;

import com.example.materia_seca.entity.MyRequest;
import com.example.materia_seca.dto.MyRequestDTO;
import com.example.materia_seca.model.CancelRequest;
import com.example.materia_seca.repository.MyRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyRequestService {

    @Autowired
    private MyRequestRepository repository;

    public MyRequest[] getRequestsByIdTechnical(int id){
        return repository.getRequestByIdTechnical(id);
    }

    public List<MyRequestDTO> getRequestDTOS(MyRequest[] requests){
        List<MyRequestDTO> dtoArray = new ArrayList<>();
        for(MyRequest r : requests)
            dtoArray.add(getRequestDTO(r));

        return dtoArray;
    }

    private MyRequestDTO getRequestDTO(MyRequest request) {
        MyRequestDTO dto = new MyRequestDTO();
        dto.setId_solicitud(request.getId_solicitud());
        dto.setId_hue(request.getHuerta().getId_hue());
        dto.setId_tecnico(request.getTechnical().getId_tecnico());
        dto.setStatus(request.getStatus());
        dto.setFecha_programada(request.getFecha_programada());
        dto.setMotivo_cancelacion(request.getMotivo_cancelacion());
        dto.setTipo(request.getTipo());
        dto.setRango(request.getRango());
        dto.setCantidad(request.getOptions().getCantidad());
        dto.setFloracion(request.getFloracion());
        dto.setId_folio(request.getId_folio());
        return dto;
    }

    public ResponseEntity<?> cancelRequest(CancelRequest cancelRequest){

        MyRequest request = repository.getRequest(cancelRequest.getId_solicitud());
        if(request == null)
            return ResponseEntity.notFound().build();

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date = currentDate.format(format);

        request.setStatus("cancelada");
        request.setFecha_fin(date);
        request.setMotivo_cancelacion(cancelRequest.getTxt());
        repository.save(request);

        return ResponseEntity.ok("Request cancel");
    }

    public void updateStatusRequest(int id, String status, Boolean dateF){
        MyRequest request = repository.getRequest(id);
        if(dateF){
            String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            request.setFecha_fin(date);
        }
        request.setStatus(status);
        repository.save(request);
    }

    public MyRequestDTO getRequestByIdAndType(int id, String type) {
        MyRequest request = repository.getRequestByIdAndType(id, type);
        return getRequestDTO(request);
    }
}
