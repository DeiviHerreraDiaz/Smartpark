package sena.ejemplo.model;

<<<<<<< HEAD
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {
=======
import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    // Atributos

    // Primary Key
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09

    @Id
    private String documento;

    @Column(name = "nombre", nullable = false)
    private String nombre;
<<<<<<< HEAD
    
    @Column(name = "password", nullable = true)
    private String password;
=======
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09

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

<<<<<<< HEAD
=======

    // CONSTRUCTORES

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    public Usuario() {

    }

<<<<<<< HEAD
    public Usuario(String documento, String nombre, String password, String apellido, String telefono, boolean estado,
            String proveniente, Rol rol) {
        this.documento = documento;
        this.nombre = nombre;
        this.password = password;
        this.apellido = apellido;
        this.telefono = telefono;
        this.estado = estado;
        this.proveniente = proveniente;
        this.rol = rol;
    }

=======
    public Usuario(String documento, String nombre, String apellido, String telefono, Rol rol, boolean estado,
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

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

<<<<<<< HEAD
    public void setPassword(String password) {
        this.password = password;
    }

=======
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
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

<<<<<<< HEAD
=======
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
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

<<<<<<< HEAD
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(rol.getNombre()));
    }

    @Override
    public String getUsername() {
        return documento;
    }

    @Override
    public String getPassword() {
        return password; 
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
=======
>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09

}
    