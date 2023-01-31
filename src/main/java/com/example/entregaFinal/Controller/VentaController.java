package com.example.entregaFinal.Controller;

import com.example.entregaFinal.Entidades.Cliente;
import com.example.entregaFinal.Entidades.Venta;
import com.example.entregaFinal.Service.ResourceNotFoundException;
import com.example.entregaFinal.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("/Ventas")

public class VentaController {
    @Autowired
    private VentaService ventaService;

    @GetMapping("/")
    public ResponseEntity<Object> findaAll(){
        return new ResponseEntity<Object>(this.ventaService.findAll() , HttpStatus.OK);
    }

    @GetMapping("/EncontrarPorId")
    public ResponseEntity<Object> findById(@RequestParam int idVenta){
        return new ResponseEntity<Object>(this.ventaService.findById(idVenta), HttpStatus.OK);
    }

    @GetMapping("/EncontrarPorFecha")
    public ResponseEntity<Object> findByFecha(@RequestParam LocalDate fecha){
        return new ResponseEntity<Object>(this.ventaService.findByFecha(fecha), HttpStatus.OK);
    }

    @GetMapping("/EncontrarPorIdCliente")
    public ResponseEntity<Object> findByIdCliente(@RequestBody Cliente cliente){
        return new ResponseEntity<Object>(this.ventaService.findByIdCliente(cliente),HttpStatus.OK);
    }

    @GetMapping("/EncontrarPorTotal")
    public ResponseEntity<Object> findByTotal(@RequestParam int total){
        return new ResponseEntity<Object>(this.ventaService.findByTotal(total), HttpStatus.OK);
    }

    @PostMapping("/Crear")
    public ResponseEntity<Venta> create(@RequestBody Venta venta) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.ventaService.create(venta), HttpStatus.OK);
    }

    @PutMapping("/Actualizar{id}")
    public ResponseEntity<Venta> update(@RequestBody Venta venta, @PathVariable int id){
        return new ResponseEntity<>(this.ventaService.update(venta , id),HttpStatus.OK);
    }


}
