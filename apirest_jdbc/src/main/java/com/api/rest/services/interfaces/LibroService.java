package com.api.rest.services.interfaces;

import com.api.rest.dto.LibroDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibroService {

    List<LibroDTO> getAllLibro();
    List<LibroDTO> findByLibro(Integer idLibro);
    void insertLibro(LibroDTO libroDTO);
    void updateLibro(LibroDTO libroDTO);
    void deleteLibro(Integer idLibro);
}
