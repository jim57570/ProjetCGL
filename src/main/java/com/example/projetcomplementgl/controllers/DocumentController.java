package com.example.projetcomplementgl.controllers;

import com.example.projetcomplementgl.entities.Document;
import com.example.projetcomplementgl.entities.Type;
import com.example.projetcomplementgl.entities.api.DocumentAPI;
import com.example.projetcomplementgl.services.DocumentService;
import com.example.projetcomplementgl.services.TypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.io.File;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/doc")
public class DocumentController {

    private Pattern pattern = Pattern.compile("\\.[^.\\\\:*?\"<>|\\r\\n]+$");

    private final DocumentService documentService;
    private final TypeService typeService;

    public DocumentController(DocumentService documentService, TypeService typeService) {
        this.documentService = documentService;
        this.typeService = typeService;
    }

    @GetMapping("")
    public ResponseEntity<List<Document>> getAll() {
        return new ResponseEntity<>(documentService.findAll(), HttpStatus.OK);
    }

    //TODO try catch
    @PostMapping("")
    public ResponseEntity<Document> add(@RequestBody DocumentAPI docForm) {
        if(docForm.type.length() > 0) {
            Type type = typeService.getByName(docForm.type);
            Document newDoc = new Document(-1L, docForm.nom, docForm.path, new Date(System.currentTimeMillis()), type);

            return new ResponseEntity<>(documentService.save(newDoc), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        documentService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
