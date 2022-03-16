package com.example.projetcomplementgl.repositories;

import com.example.projetcomplementgl.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
