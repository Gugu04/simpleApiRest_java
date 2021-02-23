package com.api.rest.services.implementation;

import com.api.rest.dto.LibroDTO;
import com.api.rest.repository.LibroRespository;
import com.api.rest.services.interfaces.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibroServiceImpl implements LibroService {
    @Autowired
    LibroRespository libroRespository;


    @Override
    public List<LibroDTO> getAllLibro() {
        return libroRespository.getAllLibro();
    }

    @Override
    public List<LibroDTO> findByLibro(Integer idLibro) {
        return libroRespository.findByLibro(idLibro);
    }

    @Override
    public void insertLibro(LibroDTO libroDTO) {
        libroRespository.insertLibro(libroDTO);
    }

    @Override
    public void updateLibro(LibroDTO libroDTO) {
        libroRespository.updateLibro(libroDTO);
    }

    @Override
    public void deleteLibro(Integer idLibro) {
        libroRespository.deleteLibro(idLibro);
    }
}
