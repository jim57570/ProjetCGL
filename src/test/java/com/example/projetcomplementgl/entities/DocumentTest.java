package com.example.projetcomplementgl.entities;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DocumentTest {

    @Test
    void creation_document(){
        Document doc = new Document();
        assertThat(doc).isNotNull();
    }

    @Test
    void creation_document_with_parameters(){
        Type type = new Type(1L, "sisi");
        Date date = new Date(2022,9,30);
        Document doc = new Document(1L,"nom", "path", date, type);

    }

    @Test
    void testGetterSetter(){
        Document doc = new Document();

        long id = 1L;
        String nom = "nom";
        String path = "path";
        Date date = new Date(2022,9,30);
        Type type = new Type(1L, "sisi");
        String test = null;

        doc.setDate(date);
        doc.setId(id);
        doc.setNom(nom);
        doc.setPath(path);
        doc.setType(type);

        assertThat(doc.getDate()).isNotNull();
        assertThat(doc.getNom()).isNotNull();
        assertThat(doc.getType()).isNotNull();
        assertThat(doc.getId()).isNotNull();
        assertThat(doc.getPath()).isNotNull();
    }

    @Test
    void testEqualHashCode(){

        Type type = new Type(1L, "sisi");
        Date date = new Date(2022,9,30);
        Document doc = new Document(1L,"nom", "path", date, type);
        Document doc2 = new Document(2L,"zidane", "pathoune", date, type);
        Document doc3 = new Document(1L,"nom", "path", date, type);


        assertThat(doc)

                .isEqualTo(doc)        // Test si les deux objets sont les mêmes

                .isNotEqualTo(doc2)     // Test si les deux objets sont strictement différents


                .isNotEqualTo("test")   // Test si les deux objets sont pas du même type

                .isEqualTo(doc3);  // Test si les deux objets sont égaux sans être le même objet ;


        assertNotEquals(doc.hashCode(), doc2.hashCode());
        assertThat(doc.hashCode()).isEqualTo(doc3.hashCode());

    }

    @Test
    void TestToString(){


        long id = 1L;
        String nom = "nom";
        String path = "path";
        Date date = new Date(2022,9,30);
        Type type = new Type(1L, "sisi");


        String message = "Document{" + "id=" + id + ", nom='" + nom + '\'' +
                ", path='" + path + '\'' +
                ", date=" + date +
                ", type=" + type +
                '}';

        Document doc = new Document(id,nom, path, date, type);

        assertThat(message).isEqualTo(doc.toString());




    }





}