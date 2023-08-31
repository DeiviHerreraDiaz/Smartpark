package sena.ejemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sena.ejemplo.model.Equipo_movimiento;
import sena.ejemplo.model.IEquipo;
import sena.ejemplo.model.IEquipo_movimiento;

import java.util.List;
@Service
public class Equipo_movimientoServiceImpl implements IEquipo_movimientoService {

    @Autowired
    private IEquipo_movimiento equipo_movimientoRepository;

    @Override
    public List<Equipo_movimiento> findAll(){return (List<Equipo_movimiento>) equipo_movimientoRepository.findAll();}

}
