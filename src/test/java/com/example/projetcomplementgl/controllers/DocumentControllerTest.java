package com.example.projetcomplementgl.controllers;

import com.example.projetcomplementgl.entities.Document;
import com.example.projetcomplementgl.entities.Stat;
import com.example.projetcomplementgl.entities.Type;
import com.example.projetcomplementgl.entities.api.DocumentAPI;
import com.example.projetcomplementgl.services.DocumentService;
import com.example.projetcomplementgl.services.TypeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class DocumentControllerTest {


    @Mock
    DocumentService documentService;

    @Mock
    TypeService typeService;

    @InjectMocks
    DocumentController documentController;


    private ResponseEntity<Document> responseCreated;
    private ResponseEntity<Document> responseBadRequest;
    private ResponseEntity<Document> responseNoContent;
    private ResponseEntity<Document> responseOk;
    private ResponseEntity<List<Document>> responseListOk;
    private Document document;
    private Document document2;
    private DocumentAPI documentapi;
    private DocumentAPI documentapinull;
    private List<Document> ListDocument;
    private Type type;


    @BeforeEach
    public void BeforeEach() {


        type = new Type(1L, "type");
        Date date = new Date(2022, 9, 30);
        document = new Document(1L, "nom", "path", date, type);
        document2 = new Document(2L, "nom", "path", date, type);
        documentapi = new DocumentAPI("nom", "path", "type");
        documentapinull = new DocumentAPI("nom", "path", "");

        ListDocument = new ArrayList<>();
        ListDocument.add(document);
        ListDocument.add(document2);





        responseCreated = new ResponseEntity<>(document, HttpStatus.CREATED);
        responseBadRequest = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        responseNoContent = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        responseOk = new ResponseEntity<>(document, HttpStatus.OK);
        responseListOk = new ResponseEntity<>(ListDocument, HttpStatus.OK);


    }

    @Test
    void givenDocumentController_whenAdd_thenCreated() {

        when(typeService.getByName(any())).thenReturn(type);
        ResponseEntity<Document> newresponse = documentController.add(documentapi);
        assertThat(newresponse.getStatusCode()).isEqualTo(responseOk.getStatusCode());

    }

    @Test
    void givenNotDocumentController_whenAdd_thenBadRequest() {

        when(typeService.getByName(any())).thenReturn(type);
        ResponseEntity<Document> newresponse = documentController.add(documentapinull);
        //assertThat(newresponse.getBody()).isInstanceOf(Document.class);
        assertThat(newresponse.getStatusCode()).isEqualTo(responseBadRequest.getStatusCode());

    }


    @Test
    void givenDocumentList_whenGetAll_thenOk() {

        when(documentService.findAll()).thenReturn(ListDocument);
        ResponseEntity<List<Document>> newresponse = documentController.getAll();
        //assertThat(newresponse.getBody()).isInstanceOf(Document.class);
        assertThat(newresponse.getStatusCode()).isEqualTo(responseListOk.getStatusCode());
    }


    @Test
    void given_whenDelete_thenDelete(){

        ResponseEntity<Void> newresponse = documentController.delete(1L);
        assertThat(newresponse.getStatusCode()).isEqualTo(responseNoContent.getStatusCode());
    }


    @Test
    void givenListStat_whenGetStatByDate_thenOk(){

        when(documentService.findAll()).thenReturn(ListDocument);
        ResponseEntity<List<Stat>> newresponse = documentController.getStatsByDate();
        assertThat(newresponse.getStatusCode()).isEqualTo(responseListOk.getStatusCode());
    }

    @Test
    void givenListStat_whenGetStatByType_thenOk(){

        when(documentService.findAll()).thenReturn(ListDocument);
        ResponseEntity<List<Stat>> newresponse = documentController.getStatsByType();
        assertThat(newresponse.getStatusCode()).isEqualTo(responseListOk.getStatusCode());
    }

    @Test
    void givenListStat_whenGetStat_thenOk(){

        when(documentService.findAll()).thenReturn(ListDocument);
        ResponseEntity<List<Stat>> newresponse = documentController.getStats();
        assertThat(newresponse.getStatusCode()).isEqualTo(responseListOk.getStatusCode());
    }




}