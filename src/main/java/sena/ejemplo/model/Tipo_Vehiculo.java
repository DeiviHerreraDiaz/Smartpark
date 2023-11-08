package sena.ejemplo.model;

import javax.persistence.*;

@Entity
@Table(name = "tipo_vehiculo")
public class Tipo_Vehiculo {

<<<<<<< HEAD
=======
    // ATRIBUTOS

    // Primary Key

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdTipo_Vehiculo;

    @Column(name = "nombre", nullable = false)
    private String nombre;

<<<<<<< HEAD
=======
    // CONSTRUCTORES

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    public Tipo_Vehiculo() {

    }

    public Tipo_Vehiculo(Integer idTipo_Vehiculo, String nombre) {
        IdTipo_Vehiculo = idTipo_Vehiculo;
        this.nombre = nombre;
    }

<<<<<<< HEAD
=======
    // GETTERS AND SETTERS

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    public Integer getIdTipo_Vehiculo() {
        return IdTipo_Vehiculo;
    }

    public void setIdTipo_Vehiculo(Integer idTipo_Vehiculo) {
        IdTipo_Vehiculo = idTipo_Vehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
