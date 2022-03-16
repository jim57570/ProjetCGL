package com.example.projetcomplementgl.repositories;

import com.example.projetcomplementgl.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Long> {

    public Optional<Type> findByNomType(String nom);
}
