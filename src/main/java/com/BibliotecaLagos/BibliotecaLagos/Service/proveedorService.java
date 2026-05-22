package com.BibliotecaLagos.BibliotecaLagos.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BibliotecaLagos.BibliotecaLagos.DTO.proveedorDTO;
import com.BibliotecaLagos.BibliotecaLagos.Model.Proveedor;
import com.BibliotecaLagos.BibliotecaLagos.Repository.proveedorRepository;

@Service
public class proveedorService {

    @Autowired
    private proveedorRepository proveedorRepository;
    public List<Proveedor> obtenerProveedores() {

        return proveedorRepository.findAll();
    }

    public Proveedor buscarPorId(Integer id) {

        return proveedorRepository.findById(id).orElse(null);
    }

    public Proveedor buscarPorNombre(String nombre) {

        return proveedorRepository.findByNombre(nombre).orElse(null);
    }

    public Proveedor crearProveedor(proveedorDTO dto) {

        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(dto.getNombre());
        proveedor.setTelefono(dto.getTelefono());
        proveedor.setCorreo(dto.getCorreo());
        proveedor.setDireccion(dto.getDireccion());
        return proveedorRepository.save(proveedor);
    }

    public Proveedor actualizarProveedor(
        Integer id,
        proveedorDTO dto) {
        Proveedor proveedor = proveedorRepository.findById(id).orElse(null);

        if(proveedor == null) {
            return null;
        }

        proveedor.setNombre(dto.getNombre());
        proveedor.setTelefono(dto.getTelefono());
        proveedor.setCorreo(dto.getCorreo());
        proveedor.setDireccion(dto.getDireccion());
        return proveedorRepository.save(proveedor);
    }

    public void eliminarProveedor(Integer id) {

        proveedorRepository.deleteById(id);
    }
}