package sena.ejemplo.service;

import org.springframework.data.repository.CrudRepository;
import sena.ejemplo.model.Equipo;


import java.util.List;

public interface IEquipoService  {

    // LISTAR

    public List<Equipo> findAll();

    // REGISTRAR EQUIPOS

    public Equipo save (Equipo equipo);

    List<Equipo> findBydocumento(String documento);


    Equipo findById(Integer equipoId);


}
