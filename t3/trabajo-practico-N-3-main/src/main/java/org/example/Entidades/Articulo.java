package org.example.Entidades;

import lombok.Builder.Default;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity

public class Articulo implements Serializable {
    @Column(name = "Cantidad")
    private int cantidad;

    @Column(name = "Denominacion")
    private String denominacion;

    @Column(name = "Precio")
    private int precio;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "articulo_categoria", joinColumns = @JoinColumn(name = "articulo_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    @Default
    private List<Categoria> categorias = new ArrayList<Categoria>();

    @OneToMany(mappedBy = "articulo")
    @Column(name = "Detalles de Facturas")
    @Default
    private List<DetalleFactura> detalleFacturas = new ArrayList<DetalleFactura>();



    public Articulo(int cantidad, String denominacion, int precio) {
        this.cantidad = cantidad;
        this.denominacion = denominacion;
        this.precio = precio;
    }

    public Articulo(int cantidad, List<Categoria> categorias, List<DetalleFactura> detalleFacturas) {
        this.cantidad = cantidad;
        this.categorias = categorias;
        this.detalleFacturas = detalleFacturas;
    }


    public int getCantidad() {
        return cantidad;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public int getPrecio() {
        return precio;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public List<DetalleFactura> getDetalleFacturas() {
        return detalleFacturas;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
        this.detalleFacturas = detalleFacturas;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }


    public Collection<DetalleFactura> getDetalle() {
        return detalleFacturas;
    }


}
