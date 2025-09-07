package com.example.materia_seca.exception;

import com.example.materia_seca.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import javax.naming.AuthenticationException;

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDTO> runTimeException(RuntimeException ex){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode(404);
        errorDTO.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorDTO> unauthorized(AuthenticationException ex){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode(401);
        errorDTO.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.UNAUTHORIZED);
    }

}
