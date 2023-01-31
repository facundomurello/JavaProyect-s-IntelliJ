package com.example.entregaFinal.Controller;

import com.example.entregaFinal.Entidades.DetalleFactura;
import com.example.entregaFinal.Service.DetalleFacturaService;
import com.example.entregaFinal.Service.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/DetalleFactura")

public class DetalleFacturaController {

    @Autowired
    private DetalleFacturaService detalleFacturaService;

    @GetMapping("/")
    public ResponseEntity<Object> findaAll(){
        return new ResponseEntity<Object>(this.detalleFacturaService.findAll() , HttpStatus.OK);
    }

    @GetMapping("/EncontrarPorId")
    public ResponseEntity<Object> findById(@RequestParam int idDetalle_Venta){
        return new ResponseEntity<Object>(this.detalleFacturaService.findById(idDetalle_Venta), HttpStatus.OK);
    }
    /*
            @GetMapping("/EncontrarIdProducto")
            public ResponseEntity<Object> findByIdProducto(@RequestParam ProductoModel productoModel){
                return new ResponseEntity<Object>(this.detalleFacturaService.findByIdProducto(productoModel), HttpStatus.OK);
            }

            @GetMapping("/EncontrarIdVenta")
            public ResponseEntity<Object> findByIdVenta(@RequestBody VentaModel ventaModel){
                return new ResponseEntity<Object>(this.detalleFacturaService.findByIdVenta(ventaModel),HttpStatus.OK);
            }
    */
    @GetMapping("/EncontrarPorCantidad")
    public ResponseEntity<Object> findByCantidad(@RequestParam int cantidad){
        return new ResponseEntity<Object>(this.detalleFacturaService.findByCantidad(cantidad), HttpStatus.OK);
    }

    @PostMapping("/Crear")
    public ResponseEntity<DetalleFactura> create(@RequestBody DetalleFactura detalleFactura) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.detalleFacturaService.create(detalleFactura), HttpStatus.OK);
    }

//        @PutMapping("/Actualizar{id}")
    //      public ResponseEntity<Producto_VentaModel> update(@RequestBody Producto_VentaModel producto_venta, @PathVariable int id){
    //        return new ResponseEntity<>(producto_ventaService.update(producto_venta , id),HttpStatus.OK);
    //  }


}
