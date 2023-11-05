package sena.ejemplo.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {

    @Id
    private String documento;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "password", nullable = true)
    private String password;

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

    public Usuario() {

    }

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

    public void setPassword(String password) {
        this.password = password;
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

}
    