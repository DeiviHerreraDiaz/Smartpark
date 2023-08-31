package sena.ejemplo.model;


import javax.persistence.*;

@Entity
@Table(name = "Equipo_movimiento")
public class _Equipo_movimiento {

    // Atributos

    // Primary Key

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Equipo_Movimiento;

    @ManyToOne
    @JoinColumn(name = "equipo_id", nullable = false)
    private _Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "movimiento_id")
    private _Movimiento movimiento;

    // MÉTODOS CONSTRUCTORES

    public _Equipo_movimiento() {

    }

    public _Equipo_movimiento(Integer id_Equipo_Movimiento, _Equipo equipo, _Movimiento movimiento) {
        this.id_Equipo_Movimiento = id_Equipo_Movimiento;
        this.equipo = equipo;
        this.movimiento = movimiento;
    }

    // GETTERS AND SETTERS

    public Integer getId_Equipo_Movimiento() {
        return id_Equipo_Movimiento;
    }

    public void setId_Equipo_Movimiento(Integer id_Equipo_Movimiento) {
        this.id_Equipo_Movimiento = id_Equipo_Movimiento;
    }

    public _Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(_Equipo equipo) {
        this.equipo = equipo;
    }

    public _Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(_Movimiento movimiento) {
        this.movimiento = movimiento;
    }


}
