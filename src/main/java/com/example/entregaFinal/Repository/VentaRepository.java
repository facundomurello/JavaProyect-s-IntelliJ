package com.example.entregaFinal.Repository;

import com.example.entregaFinal.Entidades.Cliente;
import com.example.entregaFinal.Entidades.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
    List<Venta> findByFecha(LocalDate fecha);
    List<Venta> findByIdCliente(Cliente cliente);
    List<Venta> findByTotal(int total);
}
