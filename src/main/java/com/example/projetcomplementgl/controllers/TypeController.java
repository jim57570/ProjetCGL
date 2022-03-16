package com.example.projetcomplementgl.controllers;

import com.example.projetcomplementgl.entities.Type;
import com.example.projetcomplementgl.services.ExceptionService;
import com.example.projetcomplementgl.services.TypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {

    private final TypeService typeService;

    public TypeController(TypeService typeService) { this.typeService = typeService; }

    @GetMapping("")
    public ResponseEntity<List<Type>> getAll() {
        try {
            return new ResponseEntity<>(typeService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(ExceptionService.getHttpCode(e));
        }
    }
}
