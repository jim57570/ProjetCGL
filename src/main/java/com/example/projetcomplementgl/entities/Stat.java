package com.example.projetcomplementgl.entities;

import java.util.Date;

public class Stat {

    private Date date;
    private String type;
    private Long nbDoc;

    public Stat(Date date, String type, Long nbDoc) {
        this.date = date;
        this.type = type;
        this.nbDoc = nbDoc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getNbDoc() {
        return nbDoc;
    }

    public void setNbDoc(Long nbDoc) {
        this.nbDoc = nbDoc;
    }


}
