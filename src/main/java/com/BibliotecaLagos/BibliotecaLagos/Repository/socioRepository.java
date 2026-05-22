package com.BibliotecaLagos.BibliotecaLagos.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.BibliotecaLagos.BibliotecaLagos.Model.Socio;

@Repository
public interface socioRepository
    extends JpaRepository<Socio, Integer> {
    Optional<Socio> findByRut(String rut);
    Optional<Socio> findByCorreo(String correo);
}