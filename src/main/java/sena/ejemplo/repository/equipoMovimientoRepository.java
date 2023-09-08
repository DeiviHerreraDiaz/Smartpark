package sena.ejemplo.repository;

import org.springframework.data.repository.CrudRepository;
import sena.ejemplo.model.Equipo_movimiento;
import sena.ejemplo.model.Movimiento;

import java.util.List;

public interface equipoMovimientoRepository extends CrudRepository<Equipo_movimiento, Integer> {

    List<Equipo_movimiento> findByMovimiento(Movimiento movimiento);


}
