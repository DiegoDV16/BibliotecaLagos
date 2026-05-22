package com.BibliotecaLagos.BibliotecaLagos.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BibliotecaLagos.BibliotecaLagos.DTO.libroDTO;
import com.BibliotecaLagos.BibliotecaLagos.Model.Libro;
import com.BibliotecaLagos.BibliotecaLagos.Repository.libroRepository;

@Service
public class libroService {

    @Autowired
    private libroRepository libroRepository;

    public List<Libro> obtenerLibros() {
        return libroRepository.findAll();
    }

    public Libro buscarPorId(Integer id) {
        return libroRepository.findById(id).orElse(null);
    }

    public Libro crearLibro(libroDTO dto) {

        Libro libro = new Libro();
        libro.setTitulo(dto.getTitulo());
        libro.setAutor(dto.getAutor());
        libro.setEditorial(dto.getEditorial());
        libro.setAnioPublicacion(dto.getAnioPublicacion());
        libro.setCantidadTotal(dto.getCantidadTotal());
        libro.setCantidadDisponible(dto.getCantidadTotal());
        libro.setCategoriaId(dto.getCategoriaId());
        libro.setEstado("DISPONIBLE");
        return libroRepository.save(libro);
    }

    public void eliminarLibro(Integer id) {
        libroRepository.deleteById(id);
    }
    public Libro actualizarLibro(Integer id, libroDTO dto) {
        Libro libro = libroRepository.findById(id).orElse(null);
        if(libro != null) {

            libro.setTitulo(dto.getTitulo());
            libro.setAutor(dto.getAutor());
            libro.setIsbn(dto.getIsbn());
            libro.setEditorial(dto.getEditorial());
            libro.setAnioPublicacion(dto.getAnioPublicacion());
            libro.setCantidadTotal(dto.getCantidadTotal());
            libro.setCategoriaId(dto.getCategoriaId());
            return libroRepository.save(libro);
        }

        return null;
    }

    public Libro buscarPorIsbn(String isbn) {
        return libroRepository.findByIsbn(isbn).orElse(null);
    }
}