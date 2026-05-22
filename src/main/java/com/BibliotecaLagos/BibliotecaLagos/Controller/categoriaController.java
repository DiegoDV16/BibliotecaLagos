package com.BibliotecaLagos.BibliotecaLagos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.BibliotecaLagos.BibliotecaLagos.DTO.categoriaDTO;
import com.BibliotecaLagos.BibliotecaLagos.Model.Categoria;
import com.BibliotecaLagos.BibliotecaLagos.Service.categoriaService;

@RestController
@RequestMapping("/api/v1/categorias")

public class categoriaController {

    @Autowired
    private categoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> obtenerCategorias() {

        List<Categoria> lista =
                categoriaService.obtenerCategorias();

        if(lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(
            @PathVariable Integer id) {

        Categoria categoria =
                categoriaService.buscarPorId(id);

        if(categoria == null) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Categoria no encontrada");
        }

        return ResponseEntity.ok(categoria);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> buscarPorNombre(
            @PathVariable String nombre) {

        Categoria categoria =
                categoriaService.buscarPorNombre(nombre);

        if(categoria == null) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Categoria no encontrada");
        }

        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    public ResponseEntity<?> crearCategoria(
            @RequestBody categoriaDTO dto) {

        Categoria categoria =
                categoriaService.crearCategoria(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCategoria(
            @PathVariable Integer id,
            @RequestBody categoriaDTO dto) {

        Categoria categoria =
                categoriaService.actualizarCategoria(id, dto);

        if(categoria == null) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Categoria no encontrada");
        }

        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCategoria(
            @PathVariable Integer id) {

        Categoria categoria =
                categoriaService.buscarPorId(id);

        if(categoria == null) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Categoria no encontrada");
        }

        categoriaService.eliminarCategoria(id);

        return ResponseEntity
                .ok("Categoria eliminada correctamente");
    }
}
