package com.BibliotecaLagos.BibliotecaLagos.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BibliotecaLagos.BibliotecaLagos.DTO.reservaDTO;
import com.BibliotecaLagos.BibliotecaLagos.Model.Libro;
import com.BibliotecaLagos.BibliotecaLagos.Model.Reserva;
import com.BibliotecaLagos.BibliotecaLagos.Repository.libroRepository;
import com.BibliotecaLagos.BibliotecaLagos.Repository.reservaRepository;

@Service
public class reservaService {

    @Autowired
    private reservaRepository reservaRepository;

    @Autowired
    private libroRepository libroRepository;

    public List<Reserva> obtenerReservas() {
        return reservaRepository.findAll();
    }

    public Reserva buscarPorId(Integer id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public List<Reserva> buscarPorSocio(Integer socioId) {

        return reservaRepository.findBySocioId(socioId);
    }

    public Reserva crearReserva(reservaDTO dto) {

        Libro libro = libroRepository.findById(dto.getLibroId()).orElse(null);

        if(libro == null) {
            return null;
        }

        if(libro.getCantidadDisponible() > 0) {
            return null;
        }

        Reserva reserva = new Reserva();
        reserva.setSocioId(dto.getSocioId());
        reserva.setLibroId(dto.getLibroId());
        reserva.setFechaReserva(dto.getFechaReserva());
        reserva.setEstado(dto.getEstado());
        return reservaRepository.save(reserva);
    }

    public void eliminarReserva(Integer id) {

        reservaRepository.deleteById(id);
    }
}