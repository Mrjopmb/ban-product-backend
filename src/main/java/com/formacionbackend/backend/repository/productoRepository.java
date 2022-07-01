package com.formacionbackend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacionbackend.backend.model.Producto;

public interface productoRepository extends JpaRepository<Producto, Integer>{

}
