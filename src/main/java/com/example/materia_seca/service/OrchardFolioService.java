package com.example.materia_seca.service;

import com.example.materia_seca.entity.Orchard;
import com.example.materia_seca.entity.OrchardDTO;
import com.example.materia_seca.entity.OrchardFolio;
import com.example.materia_seca.repository.OrchardFolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrchardFolioService {

    @Autowired
    private OrchardFolioRepository repository;

    public OrchardFolio getOrchardByFolio(String folio){
        return repository.getOrchardFolioByFolio(folio);
    }

    public OrchardDTO getOrchardDTO(OrchardFolio orchard){
        OrchardDTO dto = new OrchardDTO();
        dto.setId(orchard.getId_folio());
        dto.setId_productor(orchard.getId_productor());
        dto.setNombre(orchard.getNombre());
        dto.setLocalidad(orchard.getLocalidad());
        dto.setCentroide(orchard.getCentroide());
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
}
