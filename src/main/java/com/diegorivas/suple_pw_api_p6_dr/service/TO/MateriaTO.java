package com.diegorivas.suple_pw_api_p6_dr.service.TO;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class MateriaTO extends RepresentationModel<MateriaTO> {

    private Integer id;

  
    private String codigo;


    private String nombre;

   
    private String descripcion;
    
    
    private Integer numeroDeCredito;
    
}
