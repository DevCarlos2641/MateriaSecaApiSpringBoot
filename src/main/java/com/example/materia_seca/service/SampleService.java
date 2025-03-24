package com.example.materia_seca.service;

import com.example.materia_seca.entity.SampleField;
import com.example.materia_seca.entity.SampleWeight;
import com.example.materia_seca.model.RequestSampleField;
import com.example.materia_seca.repository.SampleFieldRepository;
import com.example.materia_seca.repository.SampleWeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class SampleService {

    @Autowired
    private SampleFieldRepository repository;

    @Autowired
    private SampleWeightRepository weightRepository;

    @Autowired
    private MyRequestService requestService;

    private static String UPLOAD_DIR = "images/";

    private void verifiedDir(Path path) throws IOException {
        if(!Files.exists(path))
            Files.createDirectories(path);
    }

    public ResponseEntity<?> uploadImages(MultipartFile[] files) {
        if(files.length == 0){
            return ResponseEntity.badRequest().build();
        }
        try{
            Path path = Paths.get(UPLOAD_DIR);
            String nameFile = Objects.requireNonNull(files[0].getOriginalFilename()).split("\\.")[0];
            String id = nameFile.split("-")[0];
            String hue = nameFile.split("-")[1];
            String url = id+"/"+hue+"/";

            verifiedDir(path);
            verifiedDir(Paths.get(UPLOAD_DIR+id+"/"));
            path = Paths.get(UPLOAD_DIR+id+"/"+hue+"/");
            verifiedDir(path);

            for(MultipartFile f : files){
                String nameTemp = Objects.requireNonNull(f.getOriginalFilename()).split("\\.")[0];
                String name = nameTemp.replace(id+"-"+hue+"-", "")+".png";
                Path filePath = path.resolve(name);
                Files.copy(f.getInputStream(), filePath);
            }
        } catch (Exception e) {
            ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> uploadSamplesField(RequestSampleField sampleField) {
        SampleField field = sampleField.getMuestra();
        if(field != null){
            repository.save(field);
            for(SampleWeight sample : sampleField.getPesos()){
                String name = sample.getUrl_image();
                String[] nameSplit = name.split("-");
                String id = nameSplit[0];
                String hue = nameSplit[1];
                sample.setUrl_image(name.replace(id+"-"+hue+"-", ""));
                sample.setUrl_image("/images/"+id+"/"+hue+"/"+sample.getUrl_image());
                weightRepository.save(sample);
            }
            requestService.updateStatusRequest(sampleField.getMuestra().getId_solicitud(), "laboratorio");
        } else return ResponseEntity.badRequest().build();
        return ResponseEntity.ok("Ok");
    }
}
