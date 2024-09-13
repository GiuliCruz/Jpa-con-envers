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

public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column (name=" Apellido ")
    private String apellido ;

    @Column (name ="DNI" , unique = true)
    private int dni;

    @Column (name = "Nombre")
    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "cliente")
    @Column(name = "Factura")
    @Builder.Default
    private List<Factura> facturas = new ArrayList<Factura>();



    public Cliente(String apellido, int dni, String nombre, Domicilio domicilio, List<Factura> facturas) {
        this.apellido = apellido;
        this.dni = dni;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.facturas = facturas;
    }

    public Cliente(String pablo, String muñoz, int i) {
    }


    public String getApellido() {
        return apellido;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
}
