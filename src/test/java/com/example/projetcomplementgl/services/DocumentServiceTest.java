package com.example.projetcomplementgl.services;

import com.example.projetcomplementgl.entities.Document;
import com.example.projetcomplementgl.entities.Type;
import com.example.projetcomplementgl.repositories.DocumentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class DocumentServiceTest {


    @Mock
    DocumentRepository documentRepository;

    @InjectMocks
    DocumentService documentService;



    @Test
    void whenFindAll_thenList() {
        //Given
        Type type = new Type(1L, "type");
        Date date = new Date(2022, 9, 30);
        List<Document> list = new ArrayList<>();
        Document document = new Document(1L, "nom", "path", date, type);
        Document document2 = new Document(2L, "nom", "path", date, type);
        list.add(document);
        list.add(document2);
        //When
        when(documentRepository.findAll()).thenReturn(list);
        List<Document> newList = documentService.findAll();
        //Then
        assertThat(list).isEqualTo(newList);
    }

    @Test
    void givenChoix_whenSaveChoix_thenChoix() {
        //Given
        Type type = new Type(1L, "type");
        Date date = new Date(2022, 9, 30);
        Document document = new Document(1L, "nom", "path", date, type);
        //When
        when(documentRepository.save(document)).thenReturn(document);
        Document newChoix = documentService.save(document);
        //Then
        assertThat(document).isEqualTo(newChoix);
    }

    @Test
    void whenDelete_Then(){

        Type type = new Type(1L, "type");
        Date date = new Date(2022, 9, 30);
        Document document = new Document(1L, "nom", "path", date, type);
        doNothing().when(documentRepository).deleteById(document.getId());
        documentService.remove(document.getId());
        //Then
        verify(documentRepository).deleteById(document.getId());

    }
}