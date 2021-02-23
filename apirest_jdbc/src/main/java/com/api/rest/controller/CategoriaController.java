package com.api.rest.controller;

import com.api.rest.dto.CategoriaDTO;
import com.api.rest.messages.ConstantMessages;
import com.api.rest.services.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;
    String values = null;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllCategorias() {
        return ResponseEntity.ok(categoriaService.getAllCategorias());
    }

    @GetMapping(value = "/by/{categoria}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByCategoria(@PathVariable("categoria") Integer idcategoria) {
        return ResponseEntity.ok(this.categoriaService.findByCategoria(idcategoria));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        values = null;
        if (categoriaDTO.getId_categoria() != null && !categoriaDTO.getNombre().isEmpty()) {
            this.categoriaService.insertCategoria(categoriaDTO.getNombre());

        } else {
            values = ConstantMessages.ERROR_INSERT_CATEGORIAS_VALUES;

        }
        return ResponseEntity.ok(values != null ? values : Boolean.TRUE);
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        values = null;

        if (categoriaDTO.getId_categoria() != null && !categoriaDTO.getNombre().isEmpty()) {
            if (!this.categoriaService.findByCategoria(categoriaDTO.getId_categoria()).isEmpty())
                this.categoriaService.updateCategoria(categoriaDTO);
            else
                values = ConstantMessages.ERROR_UPDATE_CATEGORIAS_ID;

        } else {
            values = ConstantMessages.ERROR_UPDATE_CATEGORIAS_VALUES;
        }

        return ResponseEntity.ok(values != null ? values : Boolean.TRUE);
    }

    @DeleteMapping(value = "/{idCategoria}/delete")
    public ResponseEntity<Object> deleteCategoria(@PathVariable Integer idCategoria) {
        categoriaService.deleteCategoria(idCategoria);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
