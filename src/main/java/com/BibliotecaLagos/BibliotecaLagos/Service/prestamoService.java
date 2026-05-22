package com.BibliotecaLagos.BibliotecaLagos.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BibliotecaLagos.BibliotecaLagos.DTO.prestamoDTO;
import com.BibliotecaLagos.BibliotecaLagos.Model.Libro;
import com.BibliotecaLagos.BibliotecaLagos.Model.Prestamo;
import com.BibliotecaLagos.BibliotecaLagos.Repository.libroRepository;
import com.BibliotecaLagos.BibliotecaLagos.Repository.prestamoRepository;

@Service
public class prestamoService {

    @Autowired
    private prestamoRepository prestamoRepository;

    @Autowired
    private libroRepository libroRepository;
    public List<Prestamo> obtenerPrestamos() {
        return prestamoRepository.findAll();
    }

    public Prestamo buscarPorId(Integer id) {
        return prestamoRepository.findById(id).orElse(null);
    }
    public List<Prestamo> buscarPorSocio(Integer socioId) {

        return prestamoRepository.findBySocioId(socioId);
    }
    public Prestamo crearPrestamo(prestamoDTO dto) {
        Libro libro =
            libroRepository.findById(dto.getLibroId())
            .orElse(null);
        if(libro == null) {
            return null;
        }
        if(libro.getCantidadDisponible() <= 0) {
            return null;
        }
        libro.setCantidadDisponible(
            libro.getCantidadDisponible() - 1);

        if(libro.getCantidadDisponible() == 0) {
            libro.setEstado("NO DISPONIBLE");
        }

        libroRepository.save(libro);
        Prestamo prestamo = new Prestamo();
        prestamo.setSocioId(dto.getSocioId());
        prestamo.setLibroId(dto.getLibroId());
        prestamo.setFechaPrestamo(dto.getFechaPrestamo());
        prestamo.setFechaDevolucion(dto.getFechaDevolucion());
        prestamo.setFechaEntrega(dto.getFechaEntrega());
        prestamo.setEstado(dto.getEstado());
        return prestamoRepository.save(prestamo);
    }

    public void eliminarPrestamo(Integer id) {

        prestamoRepository.deleteById(id);
    }
}