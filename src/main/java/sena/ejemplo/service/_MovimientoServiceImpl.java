package sena.ejemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.ejemplo.model._Equipo;
import sena.ejemplo.model._Movimiento;

import java.util.List;
import java.util.Optional;

@Service
public class _MovimientoServiceImpl implements IMovimientoService {

    @Autowired
    private sena.ejemplo.repository.movimientoRepository movimientoRepository;


    @Override
    public List<_Movimiento> findAll() {
        return (List<_Movimiento>) movimientoRepository.findAll();
    }

    @Override
    public _Movimiento save(_Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    @Override
    public void saveMovimientoAndEquipos(_Movimiento movimiento, List<_Equipo> equipos) {

    }

    @Override
    public Optional<_Movimiento> findById(Integer IdMovimiento) {
        return movimientoRepository.findById(IdMovimiento);
    }
}
