package com.BibliotecaLagos.BibliotecaLagos.Model;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservas")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer socioId;
    @Column(nullable = false)
    private Integer libroId;
    @Column(nullable = false)
    private LocalDate fechaReserva;
    private String estado;
}