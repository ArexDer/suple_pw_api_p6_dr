package com.diegorivas.suple_pw_api_p6_dr.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "materia")
public class Materia {
    

    @Id
    @GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_materia",sequenceName = "seq_materia",allocationSize = 1)
    @Column(name = "mat_id")
    private Integer id;

    @Column(name = "mat_codigo")
    private String codigo;

    @Column(name = "mat_nombre")
    private String nombre;

    @Column(name = "mat_descripcion")
    private String descripcion;
    @Column(name = "mat_numero_de_credito")
    private Integer numeroDeCredito;
}
