package com.diegorivas.suple_pw_api_p6_dr.repository;

import java.util.List;

import com.diegorivas.suple_pw_api_p6_dr.repository.model.Materia;

public interface IMateriaRepository {

    public void ingresar(Materia materia);
    public void actualizar(Materia materia);
    public void eliminar(String codigo);
    public Materia seleccionar(String codigo);
    public List<Materia> seleccionarTodos();


    
} 