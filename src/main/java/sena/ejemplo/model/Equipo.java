package sena.ejemplo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdEquipo;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @ManyToMany
    @JoinTable(
            name = "equipo_movimiento",
            joinColumns = @JoinColumn(name = "equipo_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "movimiento_id")
    )
    private List<Movimiento> movimientos;



    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "serie", nullable = false)
    private String serie;

    // Relation with documento from FK, relation of entity Usuario

    @ManyToOne
    @JoinColumn(name = "documento", nullable = false)
    private Usuario documento;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    public Equipo() {
    }

    public Equipo(Integer idEquipo, String tipo, String marca, String serie, Usuario documento, boolean estado) {
        IdEquipo = idEquipo;
        this.tipo = tipo;
        this.marca = marca;
        this.serie = serie;
        this.documento = documento;
        this.estado = estado;
    }

    public Integer getIdEquipo() {
        return IdEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        IdEquipo = idEquipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
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

}