package sena.ejemplo.model;


import javax.persistence.*;

@Entity
@Table(name = "Equipo_movimiento")
public class Equipo_movimiento {

    // Atributos

    // Primary Key

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Equipo_Movimiento;

    @ManyToOne
    @JoinColumn(name = "equipo_id", nullable = false)
    private Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "movimiento_id")
    private Movimiento movimiento;

    // MÉTODOS CONSTRUCTORES

    public Equipo_movimiento() {

    }

    public Equipo_movimiento(Integer id_Equipo_Movimiento, Equipo equipo, Movimiento movimiento) {
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

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }


}
