package com.api.rest.controller;

import com.api.rest.dto.LibroDTO;
import com.api.rest.messages.ConstantMessages;
import com.api.rest.services.interfaces.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    LibroService libroService;
    String values=null;

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllLibros(){
        return ResponseEntity.ok(libroService.getAllLibro());
    }

    @GetMapping(value = "/by/{libro}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByLibro(@PathVariable("libro") Integer idLibro){
        return ResponseEntity.ok(libroService.findByLibro(idLibro));
    }

    @PostMapping(value="/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveLibro(@RequestBody LibroDTO libroDTO){

        if(libroDTO.getId_libro()!=null){
            if(!libroService.findByLibro(libroDTO.getId_libro()).isEmpty() )
                libroService.insertLibro(libroDTO);
            else
                values= ConstantMessages.ERROR_INSERT_LIBROS_ID;
        }else{
            values= ConstantMessages.ERROR_INSERT_LIBROS_VALUES;
        }
        return ResponseEntity.ok(values!=null?values:Boolean.TRUE);

    }

    @PutMapping(value="/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateLibro(@RequestBody LibroDTO libroDTO){
        values=null;
        if(libroDTO.getId_libro()!=null){
            if(!libroService.findByLibro(libroDTO.getId_libro()).isEmpty() )
                libroService.updateLibro(libroDTO);
            else
                values= ConstantMessages.ERROR_UPDATE_LIBROS_ID;
        }else{
            values= ConstantMessages.ERROR_UPDATE_LIBROS_VALUES;
        }
        return ResponseEntity.ok(values!=null?values:Boolean.TRUE);
    }

    @DeleteMapping(value="/{libro}/delete")
    public ResponseEntity<Object> deleteLibro(@PathVariable("libro") Integer idLibro){
        libroService.deleteLibro(idLibro);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
