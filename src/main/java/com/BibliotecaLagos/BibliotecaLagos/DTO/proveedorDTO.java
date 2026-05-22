package com.BibliotecaLagos.BibliotecaLagos.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class proveedorDTO {
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;
}