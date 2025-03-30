package com.example.materia_seca.service;

import com.example.materia_seca.dto.OrchardDTO;
import com.example.materia_seca.dto.TechnicalDTO;
import com.example.materia_seca.dto.UserDTO;
import com.example.materia_seca.entity.*;
import com.example.materia_seca.model.ResponseMyRequests;
import com.example.materia_seca.model.ResponseTechnical;
import com.example.materia_seca.repository.TechnicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnicalService {

    @Autowired
    private TechnicalRepository repository;

    @Autowired
    private MyRequestService requestService;

    @Autowired
    private OrchardService orchardService;

    @Autowired
    private OrchardFolioService orchardFolioService;

    @Autowired
    private LocalBroadService localBroadService;

    public Technical getTechnical(int id_user){
        return repository.getTechnicalByIdUser(id_user);
    }

    public TechnicalDTO getTechnicalDTO(Technical technical){
        TechnicalDTO technicalDTO = new TechnicalDTO();
        technicalDTO.setId_tecnico(technical.getId_tecnico());
        technicalDTO.setId_usuario(technical.getUser().getId_usuario());
        technicalDTO.setIdjuntaLocal(technical.getJunta().getId_junta_local());
        technicalDTO.setCarga_municipios(technical.getCarga_municipios());
        technicalDTO.setEstatus(technical.getEstatus());
        return technicalDTO;
    }

    public ResponseTechnical getOResponseTechnical(UserDTO user){
        ResponseTechnical response = new ResponseTechnical();
        TechnicalDTO technicalDTO = getTechnicalDTO(
                getTechnical(user.getId_usuario())
        );
        MyRequest[] requests = requestService
                .getRequestsByIdTechnical(technicalDTO.getId_tecnico());
        List<OrchardDTO> orchards = getOrchards(requests);
        List<LocalBoard> localBoards = localBroadService.getLocalBroads(orchards);

        response.setUsuario(user);
        response.setStatus("ok");
        response.setTecnico(technicalDTO);
        response.setSolicitudes(requestService.getRequestDTOS(requests));
        response.setHuertas(orchards);
        response.setJuntas(localBoards);
        return response;
    }

    private List<OrchardDTO> getOrchards(MyRequest[] requests){
        List<OrchardDTO> orchards = new ArrayList<>();
        for (MyRequest r : requests){
            if(r.getId_folio() == null){
                orchards.add(
                        orchardService.getOrchardDTO(
                                orchardService.getOrchardByHue(r.getHuerta().getId_hue())
                        )
                );
            } else {
                orchards.add(
                        orchardFolioService.getOrchardDTO(
                                orchardFolioService.getOrchardByFolio(r.getId_folio())
                        )
                );
            }
        }
        return orchards;
    }

    public ResponseEntity<?> getMyRequestByIdTechnical(int id){
        MyRequest[] requests = requestService
                .getRequestsByIdTechnical(id);
        List<OrchardDTO> orchards = getOrchards(requests);
        List<LocalBoard> localBoards = localBroadService.getLocalBroads(orchards);

        ResponseMyRequests response = new ResponseMyRequests();
        response.setSolicitudes(requestService.getRequestDTOS(requests));
        response.setHuertas(orchards);
        response.setJuntas(localBoards);
        return ResponseEntity.ok(response);
    }
}
