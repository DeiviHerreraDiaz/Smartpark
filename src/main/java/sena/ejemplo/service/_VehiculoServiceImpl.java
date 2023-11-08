package sena.ejemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.ejemplo.model.Vehiculo;

import java.util.List;

@Service
public class _VehiculoServiceImpl implements IVehiculoService {


    @Autowired
    private sena.ejemplo.repository.vehiculoRepository vehiculoRepository;

    @Override
    public List<Vehiculo> findAll() {
        return (List<Vehiculo>) vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo save(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public List<Vehiculo> findBydocumento(String documento) {
        return vehiculoRepository.findByDocumento(documento);
    }

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
            vehiculoRepository.save(vehiculoEncontrado);
        }
        return vehiculoRepository.findById(idVehiculo).orElse(null);
    }

}
