package com.BibliotecaLagos.BibliotecaLagos.Model;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Multas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private Integer prestamoId;

    @Column(nullable = false)
    private BigDecimal monto;
    
    @Column(nullable = false)
    private Integer diasRetraso;

    @Column(nullable = false)
    private Boolean pagada;

}

//
//CREATE TABLE multas (
//    id INTEGER NOT NULL AUTO_INCREMENT,
//    prestamo_id INTEGER NOT NULL UNIQUE,
//    monto DECIMAL(10,2) NOT NULL,
//    dias_retraso INTEGER NOT NULL,
//    pagada BOOLEAN DEFAULT FALSE,
//    PRIMARY KEY (id),
//    FOREIGN KEY (prestamo_id) REFERENCES prestamos(id)
//);