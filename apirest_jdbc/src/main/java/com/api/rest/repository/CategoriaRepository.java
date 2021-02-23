package com.api.rest.repository;

import com.api.rest.dto.CategoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoriaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    List<CategoriaDTO> listcategoria=null;

    @Transactional(readOnly = true)
    public  List<CategoriaDTO> getAllCategoria() {
        listcategoria=new ArrayList<>();
        listcategoria= jdbcTemplate.query("select *from fn_get_all_categorias()",
                BeanPropertyRowMapper.newInstance( CategoriaDTO.class));
        return listcategoria;
    }

    @Transactional(readOnly = true)
    public  List<CategoriaDTO> findByCategoria(Integer nubIdCategoria ) {
        listcategoria=new ArrayList<>();
        listcategoria= jdbcTemplate.query("select *from fn_by_categoria("+nubIdCategoria+")",
                BeanPropertyRowMapper.newInstance( CategoriaDTO.class));
        return listcategoria;
    }

    public  void insertCategoria(String strNombre) {
            jdbcTemplate.update("call pr_insert_categoria(?)",strNombre);
    }

    public  void updateCategoria(CategoriaDTO categoriaDTO) {
       jdbcTemplate.update("call pr_update_categoria(?,?)",categoriaDTO.getId_categoria(),categoriaDTO.getNombre());
    }

    public  void deleteCategoria(Integer idCategoria) {
        jdbcTemplate.update("call pr_delete_categoria(?)",idCategoria);
    }

}
