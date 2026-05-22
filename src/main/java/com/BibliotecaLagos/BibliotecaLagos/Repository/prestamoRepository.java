package com.BibliotecaLagos.BibliotecaLagos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BibliotecaLagos.BibliotecaLagos.Model.Prestamo;

@Repository
public interface prestamoRepository
    extends JpaRepository<Prestamo, Integer> {
    List<Prestamo> findBySocioId(Integer socioId);
    List<Prestamo> findByLibroId(Integer libroId);
}
