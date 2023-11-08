package sena.ejemplo.model;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {

<<<<<<< HEAD
=======
    // Atributos

    // Primary Key

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdRol;

    @Column(name = "nombre", nullable = false)
<<<<<<< HEAD
    private String nombre; 
=======
    private String nombre;

    // CONSTRUCTORES
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09

    public Rol() {
    }

    public Rol(Integer idRol, String nombre) {
        IdRol = idRol;
        this.nombre = nombre;
    }

<<<<<<< HEAD
=======
    // GETTERS AND SETTERS

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    public Integer getIdRol() {
        return IdRol;
    }

    public void setIdRol(Integer idRol) {
        IdRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
