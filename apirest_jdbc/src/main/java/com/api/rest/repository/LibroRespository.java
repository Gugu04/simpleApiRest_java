package com.api.rest.repository;

import com.api.rest.dto.LibroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRespository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    List<LibroDTO> listLibroDTO = null;

    @Transactional(readOnly = true)
    public List<LibroDTO> getAllLibro() {
        listLibroDTO = new ArrayList<>();
        listLibroDTO = jdbcTemplate.query("SELECT *FROM fn_get_all_libros()", BeanPropertyRowMapper.newInstance(LibroDTO.class));
        return listLibroDTO;
    }

    @Transactional(readOnly = true)
    public List<LibroDTO> findByLibro(Integer idLibro) {
        listLibroDTO = new ArrayList<>();
        listLibroDTO = jdbcTemplate.query("SELECT *FROM fn_get_by_libro("+idLibro+")", BeanPropertyRowMapper.newInstance(LibroDTO.class));
        return listLibroDTO;
    }

    public void insertLibro(LibroDTO libroDTO) {
        jdbcTemplate.update("CALL pr_insert_libro(?,?,?,?,?,?)", libroDTO.getTitulo(),
                libroDTO.getDescripcion(),
                libroDTO.getFecha_publicado(), libroDTO.getNombre_autor(),
                libroDTO.getApellidos_autor(), libroDTO.getId_categoriafk());
    }

    public void updateLibro(LibroDTO libroDTO) {
        jdbcTemplate.update("CALL pr_update_libro(?,?,?,?,?,?,?)",libroDTO.getId_libro(),
                libroDTO.getTitulo(), libroDTO.getDescripcion(),
                libroDTO.getFecha_publicado(), libroDTO.getNombre_autor(),
                libroDTO.getApellidos_autor(), libroDTO.getId_categoriafk());
    }

    public void deleteLibro(Integer idLibro) {
        jdbcTemplate.update("CALL pr_delete_libro(?)", idLibro);
    }
}
