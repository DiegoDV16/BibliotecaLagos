package com.BibliotecaLagos.BibliotecaLagos.DTO;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class reservaDTO {
    private Integer socioId;
    private Integer libroId;
    private LocalDate fechaReserva;
    private String estado;
}