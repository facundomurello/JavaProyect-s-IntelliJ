package com.example.entregaFinal.Entidades;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    @Column
    private String nombre;
    @Column
    private double precio;
    @Column
    private int stock;


}
