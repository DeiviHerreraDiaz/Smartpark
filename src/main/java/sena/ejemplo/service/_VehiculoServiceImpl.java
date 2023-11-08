package sena.ejemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.ejemplo.model.Vehiculo;

import java.util.List;

@Service
public class _VehiculoServiceImpl implements IVehiculoService {


    @Autowired
    private sena.ejemplo.repository.vehiculoRepository vehiculoRepository;

<<<<<<< HEAD
=======
    // Obtencion de datos para la consulta (Listar)


>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    @Override
    public List<Vehiculo> findAll() {
        return (List<Vehiculo>) vehiculoRepository.findAll();
    }

<<<<<<< HEAD
=======
    // Obtencion de datos para registrar un Vehiculo


>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    @Override
    public Vehiculo save(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

<<<<<<< HEAD
=======

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    @Override
    public List<Vehiculo> findBydocumento(String documento) {
        return vehiculoRepository.findByDocumento(documento);
    }

<<<<<<< HEAD
=======

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    @Override
    public Vehiculo findOne(Integer IdVehiculo) {
        return vehiculoRepository.findById(IdVehiculo).orElse(null);
    }

    @Override
    public Vehiculo updateEstado(Integer idVehiculo, boolean estado) {
        Vehiculo vehiculoEncontrado = findOne(idVehiculo);
        if (vehiculoEncontrado != null) {
            boolean nuevoEstado = !estado;
            vehiculoEncontrado.setEstado(nuevoEstado);
            System.out.println("This 2 -> " + nuevoEstado);
<<<<<<< HEAD
            vehiculoRepository.save(vehiculoEncontrado);
        }
        return vehiculoRepository.findById(idVehiculo).orElse(null);
=======
            vehiculoRepository.save(vehiculoEncontrado); // Guarda el usuario actualizado en el repositorio
        }
        return vehiculoRepository.findById(idVehiculo).orElse(null); // Retorna el usuario actualizado o null si no se encontró
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    }

}
