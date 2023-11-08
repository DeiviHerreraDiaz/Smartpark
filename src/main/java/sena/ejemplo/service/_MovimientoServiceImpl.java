package sena.ejemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.ejemplo.model.Equipo;
import sena.ejemplo.model.Movimiento;

import java.util.List;
import java.util.Optional;

@Service
public class _MovimientoServiceImpl implements IMovimientoService {

    @Autowired
    private sena.ejemplo.repository.movimientoRepository movimientoRepository;

<<<<<<< HEAD

=======
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    @Override
    public List<Movimiento> findAll() {
        return (List<Movimiento>) movimientoRepository.findAll();
    }

    @Override
    public Movimiento save(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    @Override
    public void saveMovimientoAndEquipos(Movimiento movimiento, List<Equipo> equipos) {

    }

    @Override
    public Optional<Movimiento> findById(Integer IdMovimiento) {
        return movimientoRepository.findById(IdMovimiento);
    }
<<<<<<< HEAD


=======
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
}
