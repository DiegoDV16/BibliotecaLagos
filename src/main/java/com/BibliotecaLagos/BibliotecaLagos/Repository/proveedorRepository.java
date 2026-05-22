package com.BibliotecaLagos.BibliotecaLagos.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BibliotecaLagos.BibliotecaLagos.Model.Proveedor;

@Repository
public interface proveedorRepository
        extends JpaRepository<Proveedor, Integer> {

    Optional<Proveedor> findByNombre(String nombre);
}