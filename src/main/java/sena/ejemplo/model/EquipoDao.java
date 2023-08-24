package sena.ejemplo.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EquipoDao implements IEquipo{
    @PersistenceContext
    private EntityManager em;

    // Obtencion de datos para la consulta (Listar)

    @Transactional(readOnly = true)
    @Override 
    public List<Equipo> findAll(){
        return em.createQuery("from Equipo", Equipo.class).getResultList();
    }

    // Obtencion de datos para registrar un Equipo

    @Transactional
    @Override
    public void save(Equipo equipo){
        em.merge(equipo);
    }

    @Override
    public List<Equipo> findBydocumento(String documento) {
        return em.createQuery("from Equipo where documento = documento", Equipo.class).getResultList();
    }

    @Override
    public Equipo findById(Integer id) {
        return em.find(Equipo.class, id);
    }

   

    
}

