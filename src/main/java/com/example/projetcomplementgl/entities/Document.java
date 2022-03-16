package com.example.projetcomplementgl.entities;


import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDocument")
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name="path")
    private String path;
    @Column(name = "date")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "idType")
    private Type type;

    public Document() {
    }

    public Document(Long id, String nom, String path, Date date, Type type) {
        this.id = id;
        this.nom = nom;
        this.path = path;
        this.date = date;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        return id != null ? id.equals(document.id) : document.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", path='" + path + '\'' +
                ", date=" + date +
                ", type=" + type +
                '}';
    }
}
