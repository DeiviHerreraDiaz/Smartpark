package sena.ejemplo.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;


@Entity
@Table(name = "movimiento")
public class Movimiento {

<<<<<<< HEAD
=======

    // ATRIBUTOS

    // Primary Key

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
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

<<<<<<< HEAD
=======
    // Relation with ID VEHICULO from FK, relation of entity Vehiculo

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    @ManyToOne
    @JoinColumn(name = "IdVehiculo_Fk", nullable = false)
    private Vehiculo vehiculo;

<<<<<<< HEAD
=======
    // Relation with documento from FK, relation of entity Usuario

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    @ManyToOne
    @JoinColumn(name = "documento", nullable = false)
    private Usuario documento;

<<<<<<< HEAD
    @ManyToMany(mappedBy = "movimientos", fetch = FetchType.EAGER)
    private List<Equipo> equipos;


=======
    @ManyToMany(mappedBy = "movimientos")
    private List<Equipo> equipos;


    // CONSTRUCTORES

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    public Movimiento() {

    }

<<<<<<< HEAD
=======

    // GETTERS AND SETTERS

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
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
