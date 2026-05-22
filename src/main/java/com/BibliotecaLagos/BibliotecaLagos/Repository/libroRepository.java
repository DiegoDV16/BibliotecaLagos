package com.BibliotecaLagos.BibliotecaLagos.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BibliotecaLagos.BibliotecaLagos.Model.Libro;

@Repository
public interface libroRepository
    extends JpaRepository<Libro, Integer> {
    Optional<Libro> findByIsbn(String isbn);
}