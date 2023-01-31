package com.example.entregaFinal.Entidades;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")

public class Cliente {
    // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdCliente")
    private int idCliente;
    @Column(name="Nombre")
    private String nombre;
    @Column(name="Apellido")
    private String apellido;
    @Column(name="Dni")
    private int dni;
}
