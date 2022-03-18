package com.example.projetcomplementgl.controllers;

import com.example.projetcomplementgl.entities.Document;
import com.example.projetcomplementgl.entities.Type;
import com.example.projetcomplementgl.services.TypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class TypeControllerTest {


    @Mock
    TypeService typeService;

    @InjectMocks
    TypeController typeController;

    private ResponseEntity<List<Type>> responseListOk;
    private List<Type> ListType;

    private List<Type> Listtypage;



    @BeforeEach
    void Setup(){

        Type type = new Type(1L, "type");
        Type type2 = new Type(2L, "types");
        ListType = new ArrayList<>();
        ListType.add(type);
        ListType.add(type2);


        responseListOk = new ResponseEntity<>(ListType, HttpStatus.OK);



    }

    @Test
    void givenListType_whenGetAll_thenOk(){

        when(typeService.getAll()).thenReturn(ListType);
        ResponseEntity<List<Type>> newresponse = typeController.getAll();
        assertThat(newresponse.getBody()).isInstanceOf(List.class);
        assertThat(newresponse.getStatusCode()).isEqualTo(responseListOk.getStatusCode());
    }



}