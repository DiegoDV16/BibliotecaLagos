package com.BibliotecaLagos.BibliotecaLagos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.BibliotecaLagos.BibliotecaLagos.DTO.libroDTO;
import com.BibliotecaLagos.BibliotecaLagos.Model.Libro;
import com.BibliotecaLagos.BibliotecaLagos.Service.libroService;

@RestController
@RequestMapping("/api/v1/libros")
public class libroController {

    @Autowired
    private libroService libroService;

    // LISTAR TODOS LOS LIBROS
    @GetMapping
    public ResponseEntity<List<Libro>> obtenerLibros() {

        List<Libro> listaLibros = libroService.obtenerLibros();

        if(listaLibros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listaLibros);
    }

    // BUSCAR LIBRO POR ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(
            @PathVariable Integer id) {

        Libro libro = libroService.buscarPorId(id);

        if(libro == null) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Libro no encontrado");
        }

        return ResponseEntity.ok(libro);
    }

    // BUSCAR LIBRO POR ISBN
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<?> buscarPorIsbn(
            @PathVariable String isbn) {

        Libro libro = libroService.buscarPorIsbn(isbn);

        if(libro == null) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Libro no encontrado");
        }

        return ResponseEntity.ok(libro);
    }

    // CREAR LIBRO
    @PostMapping
    public ResponseEntity<?> crearLibro(
            @RequestBody libroDTO dto) {

        try {

            Libro libroNuevo = libroService.crearLibro(dto);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(libroNuevo);

        } catch (Exception e) {

            return ResponseEntity
                    .badRequest()
                    .body("Error al crear el libro");
        }
    }

    // ACTUALIZAR LIBRO
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarLibro(
            @PathVariable Integer id,
            @RequestBody libroDTO dto) {

        Libro libroActualizado =
                libroService.actualizarLibro(id, dto);

        if(libroActualizado == null) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Libro no encontrado");
        }

        return ResponseEntity.ok(libroActualizado);
    }

    // ELIMINAR LIBRO
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarLibro(
            @PathVariable Integer id) {

        Libro libro = libroService.buscarPorId(id);

        if(libro == null) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Libro no encontrado");
        }

        libroService.eliminarLibro(id);

        return ResponseEntity.ok("Libro eliminado correctamente");
    }
}