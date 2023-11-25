package sena.ejemplo.model;

import javax.persistence.*;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdVehiculo;

    @Column(name = "placa", nullable = false)
    private String placa;

    @Column(name = "marca", nullable = false)
    private String marca;

    @ManyToOne
    @JoinColumn(name = "tipo_vehiculo_fk", nullable = false)
    private Tipo_Vehiculo tipo_Vehiculo;

    @ManyToOne
    @JoinColumn(name = "documento", nullable = false)
    private Usuario documento;

    @Column(name = "estado", nullable = false)
    private boolean estado;

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