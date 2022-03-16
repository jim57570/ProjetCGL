package com.example.projetcomplementgl.services;

import com.example.projetcomplementgl.entities.Type;
import com.example.projetcomplementgl.repositories.TypeRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeService {

    private TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public Type getById(Long id) {
        return this.typeRepository.getById(id);
    }

    public Type getByName(String name) {
        return this.typeRepository.findByNomType(name);
    }
}
