package sena.ejemplo.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEquipo_movimiento extends CrudRepository<_Equipo_movimiento, Integer> {

    List<_Equipo_movimiento> findByMovimiento(_Movimiento movimiento);


}
