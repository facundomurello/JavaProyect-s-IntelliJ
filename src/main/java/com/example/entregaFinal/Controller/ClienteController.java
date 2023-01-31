package com.example.entregaFinal.Controller;

import com.example.entregaFinal.Entidades.Cliente;
import com.example.entregaFinal.Service.ClienteService;
import com.example.entregaFinal.Service.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Cliente")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @GetMapping("/EncontrarPorId")
    public ResponseEntity<Object> findById(@RequestParam int idCliente){
        return new ResponseEntity<Object>(this.clienteService.findById(idCliente), HttpStatus.OK);
    }

    @GetMapping("/EncontrarPorNombre")
    public ResponseEntity<Object> findByNombre(@RequestParam String nombre){
        return new ResponseEntity<Object>(this.clienteService.findByNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/EncontrarPorApellido")
    public ResponseEntity<Object> findByApellido(@RequestParam String apellido){
        return new ResponseEntity<Object>(this.clienteService.findByApellido(apellido),HttpStatus.OK);
    }

    @GetMapping("/EncontrarPorDni")
    public ResponseEntity<Object> findByDni(@RequestParam int dni){
        return new ResponseEntity<Object>(this.clienteService.findByDni(dni), HttpStatus.OK);
    }

    @PostMapping("/Crear")
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.OK);
    }

    @PutMapping("/Actualizar{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente,@PathVariable int id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.clienteService.update(cliente , id),HttpStatus.OK);
    }


}
