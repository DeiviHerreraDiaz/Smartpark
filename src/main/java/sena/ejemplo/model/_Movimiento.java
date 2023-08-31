package sena.ejemplo.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;


@Entity
@Table(name = "movimiento")
public class _Movimiento {


    // ATRIBUTOS

    // Primary Key

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdMovimiento;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "horaEntrada", nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private Time horaEntrada;

    @Column(name = "horaSalida", nullable = true)
    @DateTimeFormat(pattern = "HH:mm")
    private Time HoraSalida;

    @Column(name = "Observaciones", nullable = true)
    private String Observaciones;

    // Relation with ID VEHICULO from FK, relation of entity Vehiculo

    @ManyToOne
    @JoinColumn(name = "IdVehiculo_Fk", nullable = false)
    private _Vehiculo vehiculo;

    // Relation with documento from FK, relation of entity Usuario

    @ManyToOne
    @JoinColumn(name = "documento", nullable = false)
    private _Usuario documento;

    @ManyToMany(mappedBy = "movimientos")
    private List<_Equipo> equipos;


    // CONSTRUCTORES

    public _Movimiento() {

    }


    // GETTERS AND SETTERS

    public _Movimiento(Integer idMovimiento, Date fecha, Time horaEntrada, Time horaSalida, String observaciones,
                       _Vehiculo vehiculo, _Usuario documento, List<_Equipo> equipos) {
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


    public _Vehiculo getVehiculo() {
        return vehiculo;
    }


    public void setVehiculo(_Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }


    public _Usuario getDocumento() {
        return documento;
    }


    public void setDocumento(_Usuario documento) {
        this.documento = documento;
    }


    public List<_Equipo> getEquipos() {
        return equipos;
    }


    public void setEquipos(List<_Equipo> equipos) {
        this.equipos = equipos;
    }


}
