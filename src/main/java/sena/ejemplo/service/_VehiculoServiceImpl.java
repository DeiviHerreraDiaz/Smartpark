package sena.ejemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.ejemplo.model.Vehiculo;

import java.util.List;

@Service
public class _VehiculoServiceImpl implements IVehiculoService {


    @Autowired
    private sena.ejemplo.repository.vehiculoRepository vehiculoRepository;

    // Obtencion de datos para la consulta (Listar)


    @Override
    public List<Vehiculo> findAll() {
        return (List<Vehiculo>) vehiculoRepository.findAll();
    }

    // Obtencion de datos para registrar un Vehiculo


    @Override
    public Vehiculo save(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }


    @Override
    public List<Vehiculo> findBydocumento(String documento) {
        return vehiculoRepository.findByDocumento(documento);
    }
}
