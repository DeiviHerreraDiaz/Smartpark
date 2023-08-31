package sena.ejemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sena.ejemplo.model.IUsuario;
import sena.ejemplo.model.IVehiculo;
import sena.ejemplo.model.Vehiculo;

import java.util.List;
@Service
public class VehiculoServiceImpl implements  IVehiculoService{


    @Autowired
    private IVehiculo vehiculoRepository;

    // Obtencion de datos para la consulta (Listar)


    @Override
    public List<Vehiculo> findAll(){ return (List<Vehiculo>) vehiculoRepository.findAll();}

    // Obtencion de datos para registrar un Vehiculo


    @Override
    public Vehiculo save (Vehiculo vehiculo){return vehiculoRepository.save(vehiculo);}


    @Override
    public Vehiculo findBydocumento(String documento) {return vehiculoRepository.findByDocumento(documento);}
}
