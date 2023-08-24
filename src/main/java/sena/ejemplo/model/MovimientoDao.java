package sena.ejemplo.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MovimientoDao implements IMovimiento {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Movimiento movimiento) {
        entityManager.persist(movimiento);
    }

    @Override
    public List<Movimiento> findAll() {
        return entityManager.createQuery("from Movimiento", Movimiento.class).getResultList();
    }

    @Transactional
    @Override
    public void saveMovimientoAndEquipos(Movimiento movimiento, List<Equipo> equipos) {
        entityManager.persist(movimiento);

        for (Equipo equipo : equipos) {
            Equipo_movimiento equipoMovimiento = new Equipo_movimiento();
            equipoMovimiento.setEquipo(equipo);
            equipoMovimiento.setMovimiento(movimiento);
            entityManager.persist(equipoMovimiento);
        }
    }

    @Override
public Movimiento findById(Integer IdMovimiento) {
    return entityManager.find(Movimiento.class, IdMovimiento);
}



    
}
