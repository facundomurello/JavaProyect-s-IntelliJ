package com.example.entregaFinal.Repository;

import com.example.entregaFinal.Entidades.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer> {

    List<DetalleFactura> findByCantidad(int cantidad);

}

