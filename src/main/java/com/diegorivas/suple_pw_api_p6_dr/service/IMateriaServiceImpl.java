package com.diegorivas.suple_pw_api_p6_dr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegorivas.suple_pw_api_p6_dr.repository.IMateriaRepository;
import com.diegorivas.suple_pw_api_p6_dr.repository.model.Materia;
import com.diegorivas.suple_pw_api_p6_dr.service.TO.MateriaTO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class IMateriaServiceImpl implements IMateriaService {

    @Autowired
    private IMateriaRepository iMateriaRepository;

    //CONVERTIR
    private MateriaTO convertir(Materia materia){
        MateriaTO materiaTO = new MateriaTO();
        materiaTO.setId(materia.getId());
        materiaTO.setCodigo(materia.getCodigo());
        materiaTO.setNombre(materia.getNombre());
        materiaTO.setDescripcion(materia.getDescripcion());
        materiaTO.setNumeroDeCredito(materia.getNumeroDeCredito());
        return materiaTO;
    }

    //Inverso
    private Materia inverso(MateriaTO materiaTo){
        Materia materia = new Materia();
       // materia.setId(materia.getId());
        materia.setCodigo(materiaTo.getCodigo());
        materia.setNombre(materiaTo.getNombre());
        materia.setDescripcion(materiaTo.getDescripcion());
        materia.setNumeroDeCredito(materiaTo.getNumeroDeCredito());
        return materia;
    }

    @Override
    public void guardar(MateriaTO materiaTo) {
        
        this.iMateriaRepository.ingresar(inverso(materiaTo));
        
    }

    @Override
    public void actualizar(MateriaTO materiaTo) {
        
        Materia materia = this.iMateriaRepository.seleccionar(materiaTo.getCodigo());

        if(materia!=null){
            materia.setCodigo(materiaTo.getCodigo());
            materia.setNombre(materiaTo.getNombre());
            materia.setDescripcion(materiaTo.getDescripcion());
            materia.setNumeroDeCredito(materiaTo.getNumeroDeCredito());
            this.iMateriaRepository.actualizar(materia);

        }
        
    }

    @Override
    public void borrar(String codigo) {
        
        this.iMateriaRepository.eliminar(codigo);
        
    }

    @Override
    public MateriaTO busar(String codigo) {

        Materia materia=this.iMateriaRepository.seleccionar(codigo);
        
        return convertir(materia);
    }

    @Override
    public List<MateriaTO> buscarTodos() {
       
        List<Materia> list = this.iMateriaRepository.seleccionarTodos();
        List<MateriaTO> tos= new ArrayList<>();
        for(Materia materias: list){
            tos.add(convertir(materias));
        }
        return tos;
    }

    
    
}
