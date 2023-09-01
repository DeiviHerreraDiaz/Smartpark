package sena.ejemplo.model;

import java.util.List;

public interface IMovimiento {
    
    // LISTAR

    public List<Movimiento> findAll();
    

    // REGISTRAR EQUIPOS

    public void save (Movimiento movimiento);

    // List<Movimiento> findBydocumento(String documento);
     void saveMovimientoAndEquipos(Movimiento movimiento, List<Equipo> equipos);
     
    

    

}