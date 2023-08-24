package sena.ejemplo.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class Equipo_movimientoDao implements IEquipo_movimiento {
    @PersistenceContext
    private EntityManager em;

// Obtencion de datos para la consulta (Listar)

    @Transactional(readOnly = true)
    @Override 
    public List<Equipo_movimiento> findAll(){
        return em.createQuery("from Equipo_movimiento", Equipo_movimiento.class).getResultList();
    }

   
    
}
