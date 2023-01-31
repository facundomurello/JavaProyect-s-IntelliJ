package com.example.entregaFinal.Entidades;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "detalle_ventas")

public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "IdDetalle_Venta")
    private int idDetalle_Venta;

    @ManyToOne
    @JoinColumn(name = "IdVenta")
    private Venta idVentaModel;

    @ManyToOne
    @JoinColumn(name = "IdProducto")
    private Producto idProductoModel;

    @Column(name="Cantidad_Producto")
    private int cantidad;



}
