package com.example.projetcomplementgl.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idType")
    private Long id;
    @OneToMany
    @JoinColumn(name = "idDocument")
    @JsonManagedReference
    private Set<Document> documents;

    public Type() {
    }

    public Type(Long id, Set<Document> documents) {
        this.id = id;
        this.documents = documents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type type = (Type) o;

        return id != null ? id.equals(type.id) : type.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", documents=" + documents +
                '}';
    }
}
