package com.example.entregaFinal.Controller;

import com.example.entregaFinal.Entidades.Producto;
import com.example.entregaFinal.Service.ProductoService;
import com.example.entregaFinal.Service.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Producto")

public class ProductoController{

    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<Object>(this.productoService.findAll() , HttpStatus.OK);
    }

    @GetMapping("/EncontrarPorId")
    public ResponseEntity<Object> findById(@RequestParam int idProducto){
        return new ResponseEntity<Object>(this.productoService.findById(idProducto), HttpStatus.OK);
    }

    @GetMapping("/EncontrarPorNombre")
    public ResponseEntity<Object> findByNombre(@RequestParam String nombre){
        return new ResponseEntity<Object>(this.productoService.findByNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/EncontrarPorPrecio")
    public ResponseEntity<Object> findByPrecio(@RequestParam int precio){
        return new ResponseEntity<Object>(this.productoService.findByPrecio(precio),HttpStatus.OK);
    }

    @GetMapping("/EncontrarPorStock")
    public ResponseEntity<Object> findByStock(@RequestParam int stock){
        return new ResponseEntity<Object>(this.productoService.findByStock(stock), HttpStatus.OK);
    }

    @PostMapping("/Crear")
    public ResponseEntity<Producto> create(@RequestBody Producto producto){
        return new ResponseEntity<>(this.productoService.create(producto), HttpStatus.OK);
    }

    @PutMapping("/Actualizar{id}")
    public ResponseEntity<Producto> update(@RequestBody Producto producto,@PathVariable int id) throws ResourceNotFoundException {


        return new ResponseEntity<>(this.productoService.update(producto , id),HttpStatus.OK);
    }
}
