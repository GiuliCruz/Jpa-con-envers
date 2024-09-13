package org.example.Entidades;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.Builder;


import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity

public class DetalleFactura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "subtotal")
    private int subtotal;

    @ManyToOne(cascade =  CascadeType.PERSIST)
    @JoinColumn(name = "fk_factura")
    private Factura factura;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_articulo")
    private Articulo articulo;



    public DetalleFactura(int cantidad, int subtotal) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;

    }

    public int getCantidad() {
        return cantidad;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public Factura getFactura() {
        return factura;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
