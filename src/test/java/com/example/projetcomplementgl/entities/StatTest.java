package com.example.projetcomplementgl.entities;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatTest {

    @Test
    void creationstatTest(){
        Stat stat = new Stat();
        assertThat(stat).isNotNull();
    }

    @Test
    void creationstat_withparameters(){

        Date date = new Date(2022,9,30);
        Stat stat = new Stat(date, "type", 1L);
        assertThat(stat).isNotNull();
    }

    @Test
    void testGetterSetter(){
        Stat stat = new Stat();
        Date date = new Date(2022,9,30);

        stat.setDate(date);
        stat.setNbDoc(1L);
        stat.setType("type");

        assertThat(stat.getDate()).isNotNull();
        assertThat(stat.getType()).isNotNull();
        assertThat(stat.getNbDoc()).isNotNull();

    }




}