package com.diegorivas.suple_pw_api_p6_dr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegorivas.suple_pw_api_p6_dr.service.IMateriaService;
import com.diegorivas.suple_pw_api_p6_dr.service.TO.MateriaTO;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(path = "/materias")
public class MateriaController {

    @Autowired
    private IMateriaService iMateriaService;

    //GUARDAR
    //http://localhost:8080/API/v1.0/Matricula/materias
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MateriaTO> guardar(@RequestBody MateriaTO materiaTo){

        this.iMateriaService.guardar(materiaTo);


        return ResponseEntity.status(HttpStatus.OK).body(materiaTo);
        
    }

    //ACTUALIZAR
    @PutMapping(path = "/{codigo}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MateriaTO> actualizar(@RequestBody MateriaTO materiaTo,@PathVariable String codigo){
        materiaTo.setCodigo(codigo);

        this.iMateriaService.actualizar(materiaTo);


        return ResponseEntity.status(HttpStatus.OK).body(materiaTo);
        
    }


    //BORRAR
    @DeleteMapping(path = "/{codigo}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> borrar(@PathVariable String codigo){

        this.iMateriaService.borrar(codigo);


        return ResponseEntity.status(HttpStatus.OK).body("Materia borrada de la BD");
        
    }


    //BUSCAR
    @GetMapping(path = "/{codigo}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MateriaTO> buscar(@PathVariable String codigo){


        return ResponseEntity.status(HttpStatus.OK).body(this.iMateriaService.busar(codigo));
        
    }



    //TODOS
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MateriaTO>> buscarTodos(){

        List<MateriaTO> list = this.iMateriaService.buscarTodos();
        for(MateriaTO materiaTo: list){

            Link link = linkTo(methodOn(MateriaController.class).buscar(materiaTo.getCodigo())).withSelfRel();
            materiaTo.add(link);

        }

        return ResponseEntity.status(HttpStatus.OK).body(list);
        
    }

    
}
