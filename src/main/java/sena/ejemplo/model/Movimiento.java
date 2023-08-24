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

    @Column(name="horaEntrada", nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private Time horaEntrada;

    @Column(name="horaSalida", nullable = true)
    @DateTimeFormat(pattern = "HH:mm")
    private Time HoraSalida;

    @Column(name = "Observaciones", nullable = true)
    private String Observaciones;

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


    

    // GETTERS AND SETTERS

    public Movimiento(Integer idMovimiento, Date fecha, Time horaEntrada, Time horaSalida, String observaciones,
            Vehiculo vehiculo, Usuario documento, List<Equipo> equipos) {
        IdMovimiento = idMovimiento;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        HoraSalida = horaSalida;
        Observaciones = observaciones;
        this.vehiculo = vehiculo;
        this.documento = documento;
        this.equipos = equipos;
    }




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




    public Time getHoraEntrada() {
        return horaEntrada;
    }




    public void setHoraEntrada(Time horaEntrada) {
        this.horaEntrada = horaEntrada;
    }




    public Time getHoraSalida() {
        return HoraSalida;
    }




    public void setHoraSalida(Time horaSalida) {
        HoraSalida = horaSalida;
    }




    public String getObservaciones() {
        return Observaciones;
    }




    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
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
