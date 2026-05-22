package com.BibliotecaLagos.BibliotecaLagos.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "socios")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(unique = true, nullable = false)
    private String rut;
    @Column(unique = true, nullable = false)
    private String correo;
    private String telefono;
    @Column(nullable = false)
    private String tipoSocio;
}