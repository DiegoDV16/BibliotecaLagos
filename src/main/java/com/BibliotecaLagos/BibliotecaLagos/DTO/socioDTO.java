package com.BibliotecaLagos.BibliotecaLagos.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class socioDTO {
    private String nombre;
    private String apellido;
    private String rut;
    private String correo;
    private String telefono;
    private String tipoSocio;
}