package com.BibliotecaLagos.BibliotecaLagos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BibliotecaLagos.BibliotecaLagos.Model.Multas;

@Repository
public interface multasRepository 
        extends JpaRepository<Multas, Integer>{
    
    List<Multas> findByPagadaFalse();
    List<Multas> findByPrestamoId(Long prestamoId);
}
