package sena.ejemplo.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class VehiculoDao implements IVehiculo{
    @PersistenceContext
    private EntityManager em;


    // Obtencion de datos para la consulta (Listar)

    @Transactional(readOnly = true)
    @Override
    public List<Vehiculo> findAll(){
        return em.createQuery("from Vehiculo", Vehiculo.class).getResultList();
    }

    // Obtencion de datos para registrar un Vehiculo

    @Transactional()
    @Override
    public void save (Vehiculo vehiculo){
        em.merge(vehiculo);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Vehiculo> findBydocumento(String documento) {
        return em.createQuery("from Vehiculo where documento = documento", Vehiculo.class).getResultList();
                
    }
   
    @Transactional(readOnly = true)
    @Override
    public Vehiculo findOne(Integer IdVehiculo) {
        
        return em.find(Vehiculo.class, IdVehiculo);
    }


}
