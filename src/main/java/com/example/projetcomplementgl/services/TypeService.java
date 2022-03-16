package com.example.projetcomplementgl.services;

import com.example.projetcomplementgl.entities.Type;
import com.example.projetcomplementgl.entities.exception.BadRequestException;
import com.example.projetcomplementgl.repositories.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    private TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> getAll() {
        return this.typeRepository.findAll();
    }

    public Type getById(Long id) {
        Optional<Type> res = typeRepository.findById(id);
        if(res.isEmpty())
            throw new BadRequestException("Choix non existant");
        return res.get();
    }

    public Type getByName(String name) {
        Optional<Type> res = typeRepository.findByNomType(name);
        if(res.isEmpty())
            throw new BadRequestException("Choix non existant");
        return res.get();
    }
}
