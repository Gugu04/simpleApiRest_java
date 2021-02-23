package com.api.rest.services.implementation;

import com.api.rest.dto.CategoriaDTO;
import com.api.rest.repository.CategoriaRepository;
import com.api.rest.services.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaServicioImpl implements CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDTO> getAllCategorias() {
        return categoriaRepository.getAllCategoria();
    }

    @Override
    public List<CategoriaDTO> findByCategoria(Integer idCategoria) {
        return categoriaRepository.findByCategoria(idCategoria);
    }

    @Override
    public void insertCategoria(String strNombre) {
         categoriaRepository.insertCategoria(strNombre);
    }

    @Override
    public void updateCategoria( CategoriaDTO categoriaDTO) {
         categoriaRepository.updateCategoria(categoriaDTO);
    }

    @Override
    public void deleteCategoria(Integer idCategoria) {
        categoriaRepository.deleteCategoria(idCategoria);
    }

}
