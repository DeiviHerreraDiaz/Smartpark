package sena.ejemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.ejemplo.model.IEquipo_movimiento;
import sena.ejemplo.model._Equipo_movimiento;
import sena.ejemplo.model._Movimiento;

import java.util.List;

@Service
public class _Equipo_movimientoServiceImpl implements IEquipo_movimientoService {

    @Autowired
    private IEquipo_movimiento equipo_movimientoRepository;

    @Override
    public List<_Equipo_movimiento> findAll() {
        return (List<_Equipo_movimiento>) equipo_movimientoRepository.findAll();
    }

    @Override
    public _Equipo_movimiento save(_Equipo_movimiento equipoMovimiento) {
        return equipo_movimientoRepository.save(equipoMovimiento);
    }

    @Override
    public _Equipo_movimiento findById(Integer equipoMovimiento) {
        return equipo_movimientoRepository.findById(equipoMovimiento).orElse(null);
    }

    @Override
    public List<_Equipo_movimiento> findByMovimiento(_Movimiento movimiento) {
        return equipo_movimientoRepository.findByMovimiento(movimiento);
    }


}
