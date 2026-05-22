package com.BibliotecaLagos.BibliotecaLagos.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BibliotecaLagos.BibliotecaLagos.DTO.socioDTO;
import com.BibliotecaLagos.BibliotecaLagos.Model.Socio;
import com.BibliotecaLagos.BibliotecaLagos.Repository.socioRepository;

@Service
public class socioService {

    @Autowired
    private socioRepository socioRepository;

    public List<Socio> obtenerSocios() {
        return socioRepository.findAll();
    }

    public Socio buscarPorId(Integer id) {
        return socioRepository.findById(id).orElse(null);
    }

    public Socio buscarPorRut(String rut) {
        return socioRepository.findByRut(rut).orElse(null);
    }

    public Socio crearSocio(socioDTO dto) {

        Socio socio = new Socio();
        socio.setNombre(dto.getNombre());
        socio.setApellido(dto.getApellido());
        socio.setRut(dto.getRut());
        socio.setCorreo(dto.getCorreo());
        socio.setTelefono(dto.getTelefono());
        socio.setTipoSocio(dto.getTipoSocio());
        return socioRepository.save(socio);
    }

    public Socio actualizarSocio(Integer id, socioDTO dto) {

        Socio socio = socioRepository.findById(id).orElse(null);

        if(socio == null) {
            return null;
        }

        socio.setNombre(dto.getNombre());
        socio.setApellido(dto.getApellido());
        socio.setRut(dto.getRut());
        socio.setCorreo(dto.getCorreo());
        socio.setTelefono(dto.getTelefono());
        socio.setTipoSocio(dto.getTipoSocio());
        return socioRepository.save(socio);
    }

    public void eliminarSocio(Integer id) {
        socioRepository.deleteById(id);
    }
}