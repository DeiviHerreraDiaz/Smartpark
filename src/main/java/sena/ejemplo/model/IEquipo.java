package sena.ejemplo.model;

import java.util.List;

public interface IEquipo {
    
    // LISTAR

    public List<Equipo> findAll();

    // REGISTRAR EQUIPOS

    public void save (Equipo equipo);

    List<Equipo> findBydocumento(String documento);

    Equipo findById(Integer equipoId);


    
}
