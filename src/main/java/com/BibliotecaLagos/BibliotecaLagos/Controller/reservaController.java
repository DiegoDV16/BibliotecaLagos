package com.BibliotecaLagos.BibliotecaLagos.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.BibliotecaLagos.BibliotecaLagos.DTO.reservaDTO;
import com.BibliotecaLagos.BibliotecaLagos.Model.Reserva;
import com.BibliotecaLagos.BibliotecaLagos.Service.reservaService;

@RestController
@RequestMapping("/api/v1/reservas")

public class reservaController {

    @Autowired
    private reservaService reservaService;

    @GetMapping
    public ResponseEntity<List<Reserva>> obtenerReservas() {

        List<Reserva> lista =
                reservaService.obtenerReservas();

        if(lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(
            @PathVariable Integer id) {

        Reserva reserva = reservaService.buscarPorId(id);

        if(reserva == null) {

            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Reserva no encontrada");
        }

        return ResponseEntity.ok(reserva);
    }

    @GetMapping("/socio/{socioId}")
    public ResponseEntity<List<Reserva>> buscarPorSocio(
            @PathVariable Integer socioId) {

        List<Reserva> lista =
                reservaService.buscarPorSocio(socioId);

        if(lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<?> crearReserva(
            @RequestBody reservaDTO dto) {

        Reserva reserva = reservaService.crearReserva(dto);

        if(reserva == null) {

            return ResponseEntity
                .badRequest()
                .body("El libro aún está disponible");
        }

        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(reserva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarReserva(
            @PathVariable Integer id) {

        Reserva reserva = reservaService.buscarPorId(id);

        if(reserva == null) {

                return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Reserva no encontrada");
        }

        reservaService.eliminarReserva(id);

        return ResponseEntity
                .ok("Reserva eliminada correctamente");
    }
}