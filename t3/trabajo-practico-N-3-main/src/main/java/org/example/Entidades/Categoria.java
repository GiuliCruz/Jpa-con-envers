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

public class Categoria implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(name = "Denominacion")
private String denomicion;

@ManyToMany(mappedBy = "categorias")
private List<Articulo > articulos = new ArrayList<Articulo>();



    public Categoria(List<Articulo> articulos, String denomicion) {
        this.articulos = articulos;
        this.denomicion = denomicion;
    }

    public Categoria(String perecederos) {
    }


    public String getDenomicion() {
        return denomicion;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setDenomicion(String denomicion) {
        this.denomicion = denomicion;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }
}
