package org.example.Entidades;


import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity

public class Factura implements Serializable{

    @Column(name = "fecha")
    private String fecha;

    @Column(name =" Numero")
    private int numero;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column (name = "Total")
    private int total;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    @OneToMany (mappedBy = "factura", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<DetalleFactura > detalles = new ArrayList<DetalleFactura>();


    public Factura(String fecha, int numero, List<DetalleFactura> detalles, Cliente cliente, int total) {
        this.fecha = fecha;
        this.numero = numero;
        this.detalles = detalles;
        this.cliente = cliente;
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public int getNumero() {
        return numero;
    }

    public int getTotal() {
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }
}
