package com.diegorivas.suple_pw_api_p6_dr.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.diegorivas.suple_pw_api_p6_dr.repository.model.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class IMateriaRepositoryImpl implements  IMateriaRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void ingresar(Materia materia) {
        this.entityManager.persist(materia);
        
    }

    @Override
    public void actualizar(Materia materia) {
        this.entityManager.merge(materia);
        
    }

    @Override
    public void eliminar(String codigo) {
        Materia materia = this.seleccionar(codigo);
        this.entityManager.remove(materia);
    }

   

    @Override
    public Materia seleccionar(String codigo) {
        TypedQuery<Materia> query= this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.codigo =:codigo", Materia.class);
        query.setParameter("codigo", codigo);

        return query.getSingleResult();
    }

    @Override
    public List<Materia> seleccionarTodos() {

        TypedQuery<Materia> query= this.entityManager.createQuery("SELECT m FROM Materia m ", Materia.class);
        

        return query.getResultList();
    }

    
}
