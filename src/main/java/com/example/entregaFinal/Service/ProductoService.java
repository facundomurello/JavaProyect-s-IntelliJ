package com.example.entregaFinal.Service;

import com.example.entregaFinal.Entidades.Producto;
import com.example.entregaFinal.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private Producto create;
    @Autowired
    public ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return this.productoRepository.findAll();
    }

    public Optional<Producto> findById(int idProducto){
        return this.productoRepository.findById(idProducto);
    }

    public  List<Producto> findByNombre(String nombre){ return  this.productoRepository.findByNombre(nombre);}

    public List<Producto> findByStock(int stock){return this.productoRepository.findByStock(stock);}

    public List<Producto> findByPrecio(int precio){return  this.productoRepository.findByPrecio(precio);}

    public Producto create (Producto nuevoProducto){
        return this.productoRepository.save(nuevoProducto);
    }

    public Producto update (Producto producto , int id) throws ResourceNotFoundException {
        Optional<Producto> productoBD = this.productoRepository.findById(id);

        if(productoBD.isPresent()){
            Producto p = productoBD.get();
            p.setNombre(producto.getNombre());
            p.setPrecio(producto.getPrecio());
            p.setStock(producto.getStock());
            return this.productoRepository.save(p);

        }else{

            throw new ResourceNotFoundException("El producto no existe");
        }
    }
}
