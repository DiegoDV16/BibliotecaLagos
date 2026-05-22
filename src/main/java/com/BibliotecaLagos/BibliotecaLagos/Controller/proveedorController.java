package com.BibliotecaLagos.BibliotecaLagos.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.BibliotecaLagos.BibliotecaLagos.DTO.proveedorDTO;
import com.BibliotecaLagos.BibliotecaLagos.Model.Proveedor;
import com.BibliotecaLagos.BibliotecaLagos.Service.proveedorService;

@RestController
@RequestMapping("/api/v1/proveedores")

public class proveedorController {

    @Autowired
    private proveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<Proveedor>> obtenerProveedores() {

        List<Proveedor> lista =
                proveedorService.obtenerProveedores();

        if(lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(
            @PathVariable Integer id) {

        Proveedor proveedor =
                proveedorService.buscarPorId(id);

        if(proveedor == null) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Proveedor no encontrado");
        }

        return ResponseEntity.ok(proveedor);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> buscarPorNombre(
            @PathVariable String nombre) {

        Proveedor proveedor =
                proveedorService.buscarPorNombre(nombre);

        if(proveedor == null) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Proveedor no encontrado");
        }

        return ResponseEntity.ok(proveedor);
    }

    @PostMapping
    public ResponseEntity<?> crearProveedor(
            @RequestBody proveedorDTO dto) {

        Proveedor proveedor =
                proveedorService.crearProveedor(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(proveedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProveedor(
            @PathVariable Integer id,
            @RequestBody proveedorDTO dto) {

        Proveedor proveedor =
                proveedorService.actualizarProveedor(id, dto);

        if(proveedor == null) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Proveedor no encontrado");
        }

        return ResponseEntity.ok(proveedor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProveedor(
            @PathVariable Integer id) {

        Proveedor proveedor =
                proveedorService.buscarPorId(id);

        if(proveedor == null) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Proveedor no encontrado");
        }

        proveedorService.eliminarProveedor(id);

        return ResponseEntity
                .ok("Proveedor eliminado correctamente");
    }
}