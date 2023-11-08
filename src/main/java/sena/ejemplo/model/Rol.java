package sena.ejemplo.model;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdRol;

    @Column(name = "nombre", nullable = false)
    private String nombre; 

    public Rol() {
    }

    public Rol(Integer idRol, String nombre) {
        IdRol = idRol;
        this.nombre = nombre;
    }

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
