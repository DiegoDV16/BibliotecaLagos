package com.BibliotecaLagos.BibliotecaLagos.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BibliotecaLagos.BibliotecaLagos.Model.Categoria;

@Repository
public interface categoriaRepository
    extends JpaRepository<Categoria, Integer> {
    Optional<Categoria> findByNombre(String nombre);
}