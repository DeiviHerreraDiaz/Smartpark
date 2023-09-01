package sena.ejemplo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_movimiento")
public class Tipo_Movimiento {
    
    // ATRIBUTOS

    // Primary Key

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Tipo_Movimiento; 

    @Column(name="tipo", nullable = false)
    private String tipo;
   
    // CONSTRUCTORES

    public Tipo_Movimiento(){

    }

    public Tipo_Movimiento(Integer id_Tipo_Movimiento, String tipo) {
        Id_Tipo_Movimiento = id_Tipo_Movimiento;
        this.tipo = tipo;
    }

    // GETTERS AND SETTERS

    public Integer getId_Tipo_Movimiento() {
        return Id_Tipo_Movimiento;
    }

    public void setId_Tipo_Movimiento(Integer id_Tipo_Movimiento) {
        Id_Tipo_Movimiento = id_Tipo_Movimiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
