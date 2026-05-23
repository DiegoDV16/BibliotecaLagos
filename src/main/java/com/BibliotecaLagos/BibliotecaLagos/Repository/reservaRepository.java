package com.BibliotecaLagos.BibliotecaLagos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BibliotecaLagos.BibliotecaLagos.Model.Reserva;

@Repository
public interface reservaRepository
    extends JpaRepository<Reserva, Integer> {
    List<Reserva> findBySocioId(Integer socioId);
    List<Reserva> findByLibroId(Integer libroId);
}