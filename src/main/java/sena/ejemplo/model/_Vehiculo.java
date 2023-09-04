package sena.ejemplo.model;

import javax.persistence.*;

@Entity
@Table(name = "vehiculo")
public class _Vehiculo {

    // ATRIBUTOS

    // Primary Key

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdVehiculo;

    @Column(name = "placa", nullable = false)
    private String placa;

    @Column(name = "marca", nullable = false)
    private String marca;

    // Relation with Tipo_Vehiculo from FK, relation of entity Tipo_Vehiculo

    @ManyToOne
    @JoinColumn(name = "tipo_vehiculo_fk", nullable = false)
    private _Tipo_Vehiculo tipo_Vehiculo;

    // Relation with documento from FK, relation of entity Usuario

    @ManyToOne
    @JoinColumn(name = "documento", nullable = false)
    private _Usuario documento;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    // CONSTRUCTORES

    public _Vehiculo() {

    }

    public _Vehiculo(Integer idVehiculo, String placa, String marca, _Tipo_Vehiculo tipo_Vehiculo, _Usuario documento,
                     boolean estado) {
        IdVehiculo = idVehiculo;
        this.placa = placa;
        this.marca = marca;
        this.tipo_Vehiculo = tipo_Vehiculo;
        this.documento = documento;
        this.estado = estado;
    }

    // GETTERS AND SETTERS

    public Integer getIdVehiculo() {
        return IdVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        IdVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public _Tipo_Vehiculo getTipo_Vehiculo() {
        return tipo_Vehiculo;
    }

    public void setTipo_Vehiculo(_Tipo_Vehiculo tipo_Vehiculo) {
        this.tipo_Vehiculo = tipo_Vehiculo;
    }

    public _Usuario getDocumento() {
        return documento;
    }

    public void setDocumento(_Usuario documento) {
        this.documento = documento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void save(_Vehiculo vehiculo) {
    }

}
