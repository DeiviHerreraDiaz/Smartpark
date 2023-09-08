package sena.ejemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.ejemplo.model.IVehiculo;
import sena.ejemplo.model._Equipo;
import sena.ejemplo.model._Usuario;
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

@Override
public _Vehiculo findOne(Integer IdVehiculo) {
    return vehiculoRepository.findById(IdVehiculo).orElse(null);
}   

    @Override
public _Vehiculo updateEstado(Integer idVehiculo, boolean estado) {
    _Vehiculo vehiculoEncontrado = findOne(idVehiculo);
    if (vehiculoEncontrado != null) {
        boolean nuevoEstado = !estado;
        vehiculoEncontrado.setEstado(nuevoEstado);
        System.out.println("This 2 -> " + nuevoEstado);
        vehiculoRepository.save(vehiculoEncontrado); // Guarda el usuario actualizado en el repositorio
    }
    return vehiculoRepository.findById(idVehiculo).orElse(null); // Retorna el usuario actualizado o null si no se encontró
}

}
