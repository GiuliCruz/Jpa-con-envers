package org.example.Entidades;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.Builder;


import javax.persistence.*;
import java.io.Serializable;


@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class Domicilio implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre:calle")
    private String nombreCalle;

    @Column(name = "numero")
    private int numero;

    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;



    public Domicilio(String nombreCalle, int numero, Cliente cliente) {
        this.nombreCalle = nombreCalle;
        this.numero = numero;
        this.cliente = cliente;
    }

    public Domicilio(String nombreCalle, int numero) {
        this.nombreCalle = nombreCalle;
        this.numero = numero;
    }


    public int getNumero() {
        return numero;
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
