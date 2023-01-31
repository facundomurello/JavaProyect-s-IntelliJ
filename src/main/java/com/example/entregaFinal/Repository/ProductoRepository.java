package com.example.entregaFinal.Repository;

import com.example.entregaFinal.Entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {


    List<Producto> findByNombre(String nombreProducto);
    List<Producto> findByStock(int stock);
    List<Producto> findByPrecio(int precio);

}
