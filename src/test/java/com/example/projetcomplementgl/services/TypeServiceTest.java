package com.example.projetcomplementgl.services;

import com.example.projetcomplementgl.entities.Document;
import com.example.projetcomplementgl.entities.Type;
import com.example.projetcomplementgl.repositories.TypeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TypeServiceTest {


    @Mock
    TypeRepository typeRepository;

    @InjectMocks
    TypeService typeService;


 /*   @Test
    void whenFindAll_thenList() {
        //Given
        Type type = new Type(1L, "type");
        Type type2 = new Type(2L, "type");
        List<Type> list = new ArrayList();
        list.add(type);
        list.add(type2);
        //When
        when(typeRepository.findAll()).thenReturn(list);
        List<Type> newList = typeService.getAll();
        //Then
        assertThat(list).isEqualTo(newList);
    }

    @Test
    void givenId_whenFindById_thenCommentaire() {
        //When
        Type type = new Type(1L, "type");

        when(typeRepository.findById(type.getId())).thenReturn(Optional.of(type));
        Type gettype = typeService.getById(type.getId());
        //Then
        assertThat(type).isEqualTo(type);
    }


    @Test
    void givenId_whenFindByName_thenCommentaire() {
        //When
        Type type = new Type(1L, "type");

        when(typeRepository.findByNomType(type.getNomType())).thenReturn(Optional.of(type));
        Type gettype = typeService.getByName(type.getNomType());
        //Then
        assertThat(type).isEqualTo(type);
    } */
}