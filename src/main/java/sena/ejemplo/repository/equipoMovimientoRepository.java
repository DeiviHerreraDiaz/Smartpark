package sena.ejemplo.repository;

import org.springframework.data.repository.CrudRepository;
import sena.ejemplo.model._Equipo_movimiento;
import sena.ejemplo.model._Movimiento;

import java.util.List;

public interface equipoMovimientoRepository extends CrudRepository<_Equipo_movimiento, Integer> {

    List<_Equipo_movimiento> findByMovimiento(_Movimiento movimiento);


}
