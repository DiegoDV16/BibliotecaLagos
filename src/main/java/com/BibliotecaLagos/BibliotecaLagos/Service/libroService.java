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

    // LISTAR TODOS
    public List<Libro> obtenerLibros() {
        return libroRepository.findAll();
    }

    // BUSCAR POR ID
    public Libro buscarPorId(Integer id) {

        return libroRepository.findById(id).orElse(null);
    }

    // CREAR LIBRO
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

    // ELIMINAR
    public void eliminarLibro(Integer id) {

        libroRepository.deleteById(id);
    }
    // ACTUALIZAR LIBRO
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

    // BUSCAR POR ISBN
    public Libro buscarPorIsbn(String isbn) {

        return libroRepository.findByIsbn(isbn).orElse(null);
    }
}