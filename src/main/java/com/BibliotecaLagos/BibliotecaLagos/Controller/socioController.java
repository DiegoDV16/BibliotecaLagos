package com.BibliotecaLagos.BibliotecaLagos.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.BibliotecaLagos.BibliotecaLagos.DTO.socioDTO;
import com.BibliotecaLagos.BibliotecaLagos.Model.Socio;
import com.BibliotecaLagos.BibliotecaLagos.Service.socioService;

@RestController
@RequestMapping("/api/v1/socios")

public class socioController {

    @Autowired
    private socioService socioService;

    @GetMapping
    public ResponseEntity<List<Socio>> obtenerSocios() {

        List<Socio> lista = socioService.obtenerSocios();

        if(lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(
            @PathVariable Integer id) {

        Socio socio = socioService.buscarPorId(id);

        if(socio == null) {

            return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("Socio no encontrado");
        }

        return ResponseEntity.ok(socio);
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<?> buscarPorRut(
        @PathVariable String rut) {

        Socio socio = socioService.buscarPorRut(rut);

        if(socio == null) {

            return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("Socio no encontrado");
        }

        return ResponseEntity.ok(socio);
    }

    @PostMapping
    public ResponseEntity<?> crearSocio(
        @RequestBody socioDTO dto) {
        Socio socio = socioService.crearSocio(dto);

        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(socio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarSocio(
            @PathVariable Integer id,
            @RequestBody socioDTO dto) {

        Socio socio = socioService.actualizarSocio(id, dto);

        if(socio == null) {

            return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("Socio no encontrado");
        }

        return ResponseEntity.ok(socio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarSocio(
        @PathVariable Integer id) {

        Socio socio = socioService.buscarPorId(id);

        if(socio == null) {

            return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("Socio no encontrado");
        }

        socioService.eliminarSocio(id);

        return ResponseEntity
        .ok("Socio eliminado correctamente");
    }
}