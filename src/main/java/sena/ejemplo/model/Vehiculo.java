package sena.ejemplo.model;

import javax.persistence.*;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

<<<<<<< HEAD
=======
    // ATRIBUTOS

    // Primary Key

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdVehiculo;

    @Column(name = "placa", nullable = false)
    private String placa;

    @Column(name = "marca", nullable = false)
    private String marca;

<<<<<<< HEAD
=======
    // Relation with Tipo_Vehiculo from FK, relation of entity Tipo_Vehiculo

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    @ManyToOne
    @JoinColumn(name = "tipo_vehiculo_fk", nullable = false)
    private Tipo_Vehiculo tipo_Vehiculo;

<<<<<<< HEAD
=======
    // Relation with documento from FK, relation of entity Usuario

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    @ManyToOne
    @JoinColumn(name = "documento", nullable = false)
    private Usuario documento;

    @Column(name = "estado", nullable = false)
    private boolean estado;

<<<<<<< HEAD
=======
    // CONSTRUCTORES

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
    public Vehiculo() {

    }

    public Vehiculo(Integer idVehiculo, String placa, String marca, Tipo_Vehiculo tipo_Vehiculo, Usuario documento,
                    boolean estado) {
        IdVehiculo = idVehiculo;
        this.placa = placa;
        this.marca = marca;
        this.tipo_Vehiculo = tipo_Vehiculo;
        this.documento = documento;
        this.estado = estado;
    }

<<<<<<< HEAD
=======
    // GETTERS AND SETTERS

>>>>>>> dcd4b21feb5d92f81affd35208995ba7257f5d09
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

    public Tipo_Vehiculo getTipo_Vehiculo() {
        return tipo_Vehiculo;
    }

    public void setTipo_Vehiculo(Tipo_Vehiculo tipo_Vehiculo) {
        this.tipo_Vehiculo = tipo_Vehiculo;
    }

    public Usuario getDocumento() {
        return documento;
    }

    public void setDocumento(Usuario documento) {
        this.documento = documento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void save(Vehiculo vehiculo) {
    }

}
