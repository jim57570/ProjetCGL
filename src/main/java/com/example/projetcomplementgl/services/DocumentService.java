package com.example.projetcomplementgl.services;

import com.example.projetcomplementgl.entities.Document;
import com.example.projetcomplementgl.repositories.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    private DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<Document> findAll() { return this.documentRepository.findAll(); }

    public Document save(Document newDocument) {
        return this.documentRepository.save(newDocument);
    }

    public void remove(Long id) {
        this.documentRepository.deleteById(id);
    }
}
