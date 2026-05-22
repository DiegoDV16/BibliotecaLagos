package com.BibliotecaLagos.BibliotecaLagos.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class libroDTO {

    private String titulo;
    private String autor;
    private String isbn;
    private String editorial;
    private Integer anioPublicacion;
    private Integer cantidadTotal;
    private Integer categoriaId;
    private Integer proveedorId;
}