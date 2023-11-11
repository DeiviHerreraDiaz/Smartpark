package sena.ejemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.ejemplo.model.Equipo_movimiento;
import sena.ejemplo.model.Movimiento;
import sena.ejemplo.repository.equipoMovimientoRepository;

import java.util.List;

@Service
public class _Equipo_movimientoServiceImpl implements IEquipo_movimientoService {

    @Autowired
    private equipoMovimientoRepository equipo_movimientoRepository;

    @Override
    public List<Equipo_movimiento> findAll() {
        return (List<Equipo_movimiento>) equipo_movimientoRepository.findAll();
    }

    @Override
    public Equipo_movimiento save(Equipo_movimiento equipoMovimiento) {
        return equipo_movimientoRepository.save(equipoMovimiento);
    }

    @Override
    public Equipo_movimiento findById(Integer equipoMovimiento) {
        return equipo_movimientoRepository.findById(equipoMovimiento).orElse(null);
    }

    @Override
    public List<Equipo_movimiento> findByMovimiento(Movimiento movimiento) {
        return equipo_movimientoRepository.findByMovimiento(movimiento);
    }


}