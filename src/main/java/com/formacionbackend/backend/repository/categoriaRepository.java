package com.formacionbackend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacionbackend.backend.model.Categoria;

public interface categoriaRepository extends JpaRepository<Categoria, Integer> {

}
