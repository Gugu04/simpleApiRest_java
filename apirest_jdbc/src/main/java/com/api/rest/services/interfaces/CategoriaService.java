package com.api.rest.services.interfaces;

import com.api.rest.dto.CategoriaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoriaService {
    List<CategoriaDTO> getAllCategorias();
    List<CategoriaDTO> findByCategoria(Integer Idcategoria);
    void insertCategoria(String strNombre);
    void updateCategoria(CategoriaDTO categoriaDTO);
    void deleteCategoria(Integer idCategoria);
}
