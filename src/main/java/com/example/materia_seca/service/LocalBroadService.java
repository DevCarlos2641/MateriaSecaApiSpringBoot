package com.example.materia_seca.service;

import com.example.materia_seca.entity.LocalBoard;
import com.example.materia_seca.entity.OrchardDTO;
import com.example.materia_seca.repository.LocalBroadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocalBroadService {

    @Autowired
    private LocalBroadRepository repository;

    public LocalBoard getLocalBroadById(int id){
        return repository.getLocalBoardById(id);
    }

    public List<LocalBoard> getLocalBroads(List<OrchardDTO> orchards){
        List<LocalBoard> localBoards = new ArrayList<>();
        for(OrchardDTO o : orchards){
            LocalBoard lb = getLocalBroadById(o.getId_junta_local());
            if(!localBoards.contains(lb)){
                localBoards.add(lb);
            }
        }
        return localBoards;
    }

}
