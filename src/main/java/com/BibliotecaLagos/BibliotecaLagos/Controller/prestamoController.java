package com.BibliotecaLagos.BibliotecaLagos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.BibliotecaLagos.BibliotecaLagos.DTO.prestamoDTO;
import com.BibliotecaLagos.BibliotecaLagos.Model.Prestamo;
import com.BibliotecaLagos.BibliotecaLagos.Service.prestamoService;

@RestController
@RequestMapping("/api/v1/prestamos")

public class prestamoController {

    @Autowired
    private prestamoService prestamoService;

    @GetMapping
    public ResponseEntity<List<Prestamo>> obtenerPrestamos() {

        List<Prestamo> lista =
            prestamoService.obtenerPrestamos();

        if(lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(
            @PathVariable Integer id) {

        Prestamo prestamo =
            prestamoService.buscarPorId(id);

        if(prestamo == null) {

            return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("Prestamo no encontrado");
        }

        return ResponseEntity.ok(prestamo);
    }

    @GetMapping("/socio/{socioId}")
    public ResponseEntity<List<Prestamo>> buscarPorSocio(
            @PathVariable Integer socioId) {

        List<Prestamo> lista =
        prestamoService.buscarPorSocio(socioId);

        if(lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<?> crearPrestamo(
        @RequestBody prestamoDTO dto) {

        Prestamo prestamo =
        prestamoService.crearPrestamo(dto);

        if(prestamo == null) {

            return ResponseEntity
            .badRequest()
            .body("Libro no disponible");
        }

        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(prestamo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPrestamo(
            @PathVariable Integer id) {

        Prestamo prestamo =
        prestamoService.buscarPorId(id);

        if(prestamo == null) {

            return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("Prestamo no encontrado");
        }

        prestamoService.eliminarPrestamo(id);
        return ResponseEntity
        .ok("Prestamo eliminado correctamente");
    }
}