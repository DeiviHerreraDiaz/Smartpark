package sena.ejemplo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    // Atributos

    // Primary Key

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer documento;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    @Column(name = "proveniente", nullable = true)
    private String proveniente;

    // Relation with ID Rol from FK, relation of entity Rol

    @ManyToOne
    @JoinColumn(name = "Id_Rol_Fk", nullable = false)
    private Rol rol;

    // CONSTRUCTORES

    public Usuario() {

    }

    public Usuario(Integer documento, String nombre, String apellido, String telefono, Rol rol, boolean estado,
            String proveniente) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.rol = rol;
        this.estado = estado;
        this.proveniente = proveniente;
    }

    // GETTERS AND SETTERS

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getProveniente() {
        return proveniente;
    }

    public void setProveniente(String proveniente) {
        this.proveniente = proveniente;
    }

}