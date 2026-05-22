package com.BibliotecaLagos.BibliotecaLagos.DTO;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class multasDTO {
    private Integer prestamoId;
    private BigDecimal monto;
    private Integer diasRetraso;
    private Boolean pagada;
}
