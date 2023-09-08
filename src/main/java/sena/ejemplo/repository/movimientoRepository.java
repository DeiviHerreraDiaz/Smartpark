package sena.ejemplo.repository;

import org.springframework.data.repository.CrudRepository;
import sena.ejemplo.model.Movimiento;

public interface movimientoRepository extends CrudRepository<Movimiento, Integer> {


}