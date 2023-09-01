package sena.ejemplo.model;


import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="movimiento")
public class Movimiento {
    

   
    // ATRIBUTOS

    // Primary Key

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdMovimiento;

    @Column(name="fecha", nullable = false)
    private Date fecha;

    @Column(name="hora", nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private Time hora;

    @ManyToOne
    @JoinColumn(name ="Tipo_Movimiento_Fk", nullable = false)
    private Tipo_Movimiento tipo_Movimiento;

    // Relation with ID VEHICULO from FK, relation of entity Vehiculo

    @ManyToOne
    @JoinColumn(name = "IdVehiculo_Fk", nullable = false)
    private Vehiculo vehiculo; 

    // Relation with documento from FK, relation of entity Usuario
    
    @ManyToOne
    @JoinColumn(name = "documento", nullable = false)
    private Usuario documento;

    @ManyToMany(mappedBy = "movimientos")
    private List<Equipo> equipos;

    

    // CONSTRUCTORES

    public Movimiento(){

    }

    

    

    public Movimiento(Integer idMovimiento, Date fecha, Time hora, Tipo_Movimiento tipo_Movimiento, Vehiculo vehiculo,
            Usuario documento, List<Equipo> equipos) {
        IdMovimiento = idMovimiento;
        this.fecha = fecha;
        this.hora = hora;
        this.tipo_Movimiento = tipo_Movimiento;
        this.vehiculo = vehiculo;
        this.documento = documento;
        this.equipos = equipos;
    }


    // GETTERS AND SETTERS


    public Integer getIdMovimiento() {
        return IdMovimiento;
    }





    public void setIdMovimiento(Integer idMovimiento) {
        IdMovimiento = idMovimiento;
    }





    public Date getFecha() {
        return fecha;
    }





    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }





    public Time getHora() {
        return hora;
    }





    public void setHora(Time hora) {
        this.hora = hora;
    }





    public Tipo_Movimiento getTipo_Movimiento() {
        return tipo_Movimiento;
    }





    public void setTipo_Movimiento(Tipo_Movimiento tipo_Movimiento) {
        this.tipo_Movimiento = tipo_Movimiento;
    }





    public Vehiculo getVehiculo() {
        return vehiculo;
    }





    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }





    public Usuario getDocumento() {
        return documento;
    }





    public void setDocumento(Usuario documento) {
        this.documento = documento;
    }





    public List<Equipo> getEquipos() {
        return equipos;
    }





    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

   
    


    
}
