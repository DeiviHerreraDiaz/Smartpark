package sena.ejemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.ejemplo.model.IVehiculo;
import sena.ejemplo.model._Vehiculo;

import java.util.List;

@Service
public class _VehiculoServiceImpl implements IVehiculoService {


    @Autowired
    private IVehiculo vehiculoRepository;

    // Obtencion de datos para la consulta (Listar)


    @Override
    public List<_Vehiculo> findAll() {
        return (List<_Vehiculo>) vehiculoRepository.findAll();
    }

    // Obtencion de datos para registrar un Vehiculo


    @Override
    public _Vehiculo save(_Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }


    @Override
    public List<_Vehiculo> findBydocumento(String documento) {
        return vehiculoRepository.findByDocumento(documento);
    }
}
