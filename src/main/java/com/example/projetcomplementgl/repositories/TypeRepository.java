package com.example.projetcomplementgl.repositories;

import com.example.projetcomplementgl.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {

    public Type findByNomType(String nom);
}
