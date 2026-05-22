package com.BibliotecaLagos.BibliotecaLagos.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BibliotecaLagos.BibliotecaLagos.DTO.categoriaDTO;
import com.BibliotecaLagos.BibliotecaLagos.Model.Categoria;
import com.BibliotecaLagos.BibliotecaLagos.Repository.categoriaRepository;

@Service
public class categoriaService {

    @Autowired
    private categoriaRepository categoriaRepository;

    public List<Categoria> obtenerCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Integer id) {

        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria buscarPorNombre(String nombre) {

        return categoriaRepository.findByNombre(nombre).orElse(null);
    }

    public Categoria crearCategoria(categoriaDTO dto) {

        Categoria categoria = new Categoria();

        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());

        return categoriaRepository.save(categoria);
    }

    public Categoria actualizarCategoria(Integer id,categoriaDTO dto) {

        Categoria categoria = categoriaRepository.findById(id).orElse(null);

        if(categoria == null) {
            return null;
        }

        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());

        return categoriaRepository.save(categoria);
    }

    public void eliminarCategoria(Integer id) {

        categoriaRepository.deleteById(id);
    }
}