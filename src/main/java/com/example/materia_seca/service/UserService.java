package com.example.materia_seca.service;

import com.example.materia_seca.dto.UserDTO;
import com.example.materia_seca.entity.*;
import com.example.materia_seca.model.RequestUser;
import com.example.materia_seca.model.ResponseLaboratory;
import com.example.materia_seca.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TechnicalService technicalService;

    public ResponseEntity<?> verifiedUser(RequestUser credential){
        User user = repository.findUserByEmail(credential.getEmail());
        if(user == null)
            return ResponseEntity.notFound().build();
        if(passwordEncoder.matches(credential.getPassword(), user.getPassword())) {
            int type = user.getUserType().getId_tipo();
            UserDTO userDTO = getUserDTO(user);
            if (type == 2){
                // this user is technical
                return ResponseEntity.ok(
                        technicalService.getOResponseTechnical(userDTO)
                );

            } else if (type == 3){
                // this user is laboratory
                ResponseLaboratory response = new ResponseLaboratory();
                response.setStatus("ok");
                response.setUsuario(userDTO);
                return ResponseEntity.ok(response);

            } else {
                return ResponseEntity.badRequest().body("Usuario incorrecto");
            }
        }
        else return ResponseEntity.badRequest().body("Constreña incorrecta");
    }

    public UserDTO getUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId_usuario(user.getId_usuario());
        userDTO.setId_tipo(user.getUserType().getId_tipo());
        userDTO.setNombre(user.getNombre());
        userDTO.setTelefono(user.getTelefono());
        userDTO.setCorreo(user.getCorreo());
        return userDTO;
    }

}
