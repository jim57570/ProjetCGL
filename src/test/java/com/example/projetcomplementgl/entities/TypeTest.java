package com.example.projetcomplementgl.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TypeTest {

    @Test
    void creation_type(){
        Type type = new Type();
        assertThat(type).isNotNull();
    }

    @Test
    void creation_type_withparameters(){
        Type type = new Type(1L, "type");
        assertThat(type).isNotNull();
    }

    @Test
    void testGetterSetter(){

        Type type = new Type();

        long id = 1L;
        String types = "type";

        type.setNomType(types);
        type.setId(id);

        assertThat(type.getId()).isNotNull();
        assertThat(type.getNomType()).isNotNull();
    }

    @Test
    void testEqualsHashcode(){

        Type type = new Type(1L, "type");
        Type type2 = new Type(2L, "types");
        Type type3 = new Type(1L, "type");


        assertThat(type)

                .isEqualTo(type)        // Test si les deux objets sont les mêmes

                .isNotEqualTo(type2)     // Test si les deux objets sont strictement différents


                .isNotEqualTo("test")   // Test si les deux objets sont pas du même type

                .isEqualTo(type3);  // Test si les deux objets sont égaux sans être le même objet ;


        assertNotEquals(type.hashCode(), type2.hashCode());
        assertThat(type.hashCode()).isEqualTo(type3.hashCode());
    }


    @Test
    void testToString(){
        long id = 1L;
        String nomType = "type";
        Type type = new Type(id, nomType);

        String message = "Type{" +
                "id=" + id +
                ", nomType='" + nomType + '\'' +
                '}';

        assertThat(message).isEqualTo(type.toString());
    }

}