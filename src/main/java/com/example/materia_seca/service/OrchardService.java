package com.example.materia_seca.service;

import com.example.materia_seca.dto.MyRequestDTO;
import com.example.materia_seca.dto.OrchardDTO;
import com.example.materia_seca.entity.*;
import com.example.materia_seca.model.RequestGetUrls;
import com.example.materia_seca.model.ResponseOrchardLaboratory;
import com.example.materia_seca.repository.OrchardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrchardService {

    @Autowired
    private OrchardRepository repository;

    @Autowired
    private OrchardFolioService orchardFolioService;

    @Autowired
    private MyRequestService requestService;

    public Orchard getOrchardByHue(String hue){
        return repository.getOrchardByHue(hue);
    }

    public OrchardDTO getOrchardDTO(Orchard orchard){
        OrchardDTO dto = new OrchardDTO();
        dto.setId(orchard.getId_hue());
        dto.setId_productor(orchard.getId_productor());
        dto.setNombre(orchard.getNombre());
        dto.setLocalidad(orchard.getLocalidad());
        dto.setCentroide(orchard.getCentroide());
        dto.setHectareas(orchard.getHectareas());
        dto.setPronostico_de_cosecha(orchard.getPronostico_de_cosecha());
        dto.setLongitud(orchard.getLongitud());
        dto.setAltura_nivel_del_mar(orchard.getAltura_nivel_del_mar());
        dto.setVariedad(orchard.getVariedad());
        dto.setAnoplantacion(orchard.getAnoplantacion());
        dto.setArbolesporhectareas(orchard.getArbolesporhectareas());
        dto.setEtapafenologica(orchard.getEtapafenologica());
        dto.setFechasv_01(orchard.getFechasv_01());
        dto.setFechasv_02(orchard.getFechasv_02());
        dto.setRutaKML(orchard.getRutaKML());
        dto.setFecha_registro(orchard.getFecha_registro());
        dto.setId_junta_local(orchard.getId_junta_local());
        dto.setLatitud(orchard.getLatitud());
        return dto;
    }

    public ResponseEntity<?> getUrlsKml(RequestGetUrls request){
        List<String> urls = new ArrayList<>();
        for (String id : request.getUrls()){
            String url = getUrlKmlById(id);
            if(url != null)
                urls.add(url);
        }
        return ResponseEntity.ok(urls);
    }

    private String getUrlKmlById(String id) {
        Orchard orchard = repository.getOrchardByHue(id);
        if (orchard == null){
            OrchardFolio orchardFolio = orchardFolioService.getOrchardByFolio(id);
            if(orchardFolio == null) return null;
            else return orchardFolio.getRutaKML();
        } else return orchard.getRutaKML();
    }

    public ResponseEntity<?> getOrchardForLaboratory(int id_solicitud, String tipo) {
        MyRequestDTO request = requestService.getRequestByIdAndType(id_solicitud, tipo);
        OrchardDTO orchardDTO = new OrchardDTO();
        if(request != null){
            if(request.getStatus().equals("laboratorio") && request.getTipo().equals("exportacion") ||
                    request.getStatus().equals("activa") && request.getTipo().equals("nacional")){
                if(request.getId_hue() != null)
                    orchardDTO = getOrchardDTO(getOrchardByHue(request.getId_hue()));
                else
                    orchardDTO = orchardFolioService
                            .getOrchardDTO(orchardFolioService
                                    .getOrchardByFolio(request.getId_folio()));
            }
        } else ResponseEntity.badRequest().build();
        ResponseOrchardLaboratory response = new ResponseOrchardLaboratory();
        response.setOrchard(orchardDTO);
        response.setRequest(request);
        return ResponseEntity.ok(response);
    }
}
