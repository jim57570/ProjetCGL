package com.example.projetcomplementgl.controllers;

import com.example.projetcomplementgl.entities.Document;
import com.example.projetcomplementgl.entities.Stat;
import com.example.projetcomplementgl.entities.Type;
import com.example.projetcomplementgl.entities.api.DocumentAPI;
import com.example.projetcomplementgl.services.DocumentService;
import com.example.projetcomplementgl.services.TypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doc")
public class DocumentController {

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
            Document newDoc = new Document(-1L, docForm.nom, docForm.path, Date.valueOf(LocalDate.now()), type);

            return new ResponseEntity<>(documentService.save(newDoc), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        documentService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/stats/date")
    public ResponseEntity<List<Stat>> getStatsByDate(){
        List<Document> listDoc = documentService.findAll();
        Map<Date, Long> stats = listDoc.stream().collect(Collectors.groupingBy(Document::getDate, Collectors.counting()));
        List<Stat> listStat = new ArrayList<>();
        stats.forEach((k, v) -> listStat.add(new Stat(k, "", v)));
        return new ResponseEntity<>(listStat, HttpStatus.OK);
    }

    @GetMapping("/stats/type")
    public ResponseEntity<List<Stat>> getStatsByType(){
        List<Document> list = documentService.findAll();
        Map<String, Long> stats = list.stream().collect(Collectors.groupingBy(l -> l.getType().getNomType(), Collectors.counting()));
        List<Stat> listStat = new ArrayList<>();
        stats.forEach((k, v) -> listStat.add(new Stat(null, k, v)));
        return new ResponseEntity<>(listStat, HttpStatus.OK);
    }

    @GetMapping("/stats")
    public ResponseEntity<List<Stat>> getStats(){
        List<Document> list = documentService.findAll();
        Map<Date, Map<String, Long>> stats = list.stream().collect(Collectors.groupingBy(d -> d.getDate(), Collectors.groupingBy(l -> l.getType().getNomType(), Collectors.counting())));
        List<Stat> listStat = new ArrayList<>();
        stats.forEach((date, map) -> map.forEach((type, nb) -> listStat.add(new Stat(date, type, nb))));
        return new ResponseEntity<>(listStat, HttpStatus.OK);
    }

}
