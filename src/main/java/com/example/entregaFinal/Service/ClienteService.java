package com.example.entregaFinal.Service;

import com.example.entregaFinal.Entidades.Cliente;
import com.example.entregaFinal.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private Cliente create;
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return this.clienteRepository.findAll();
    }

    public Optional<Cliente> findById(int idCliente){
        return this.clienteRepository.findById(idCliente);
    }

    public  List<Cliente> findByNombre(String nombre){ return  this.clienteRepository.findByNombre(nombre);}

    public List<Cliente> findByApellido(String apellido){return this.clienteRepository.findByApellido(apellido);}

    public List<Cliente> findByDni(int dni){return  this.clienteRepository.findByDni(dni);}

    public Cliente create (Cliente nuevoCliente){
        return this.clienteRepository.save(nuevoCliente);
    }

    public Cliente update (Cliente clienteNuevo , int id) throws ResourceNotFoundException {
        Optional<Cliente> clienteBD = this.clienteRepository.findById(id);
        Cliente cliente = new Cliente();
        if(clienteBD.isPresent()){
            cliente = clienteBD.get();
            cliente.setNombre(clienteNuevo.getNombre());
            cliente.setApellido(clienteNuevo.getApellido());
            cliente.setDni(clienteNuevo.getDni());
            return this.clienteRepository.save(cliente);
        }//else{
        // throw new ResourceNotFoundException("El cliente no existe");
        //}
        return this.clienteRepository.save(cliente);
    }
}
