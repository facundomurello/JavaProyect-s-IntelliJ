package com.example.entregaFinal.Repository;

import com.example.entregaFinal.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {


    List<Cliente> findByNombre(String nombreCliente);
    List<Cliente> findByApellido(String apellidoCliente);
    List<Cliente> findByDni(int dni);

}
