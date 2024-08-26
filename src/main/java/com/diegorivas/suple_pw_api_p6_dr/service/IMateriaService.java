package com.diegorivas.suple_pw_api_p6_dr.service;

import java.util.List;

import com.diegorivas.suple_pw_api_p6_dr.repository.model.Materia;
import com.diegorivas.suple_pw_api_p6_dr.service.TO.MateriaTO;

public interface IMateriaService {

    public void guardar(MateriaTO materiaTo);
    public void actualizar(MateriaTO materiaTo);
    public void borrar(String codigo);
    public MateriaTO busar(String codigo);
    public List<MateriaTO> buscarTodos();
    
}
