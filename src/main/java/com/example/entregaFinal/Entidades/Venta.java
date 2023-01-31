package com.example.entregaFinal.Entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "ventas")

public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;
    @Column
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "IdCliente")
    private Cliente idCliente;

    @Column
    private int total;



}
