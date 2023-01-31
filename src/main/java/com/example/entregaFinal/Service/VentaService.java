package com.example.entregaFinal.Service;

import com.example.entregaFinal.Entidades.Cliente;
import com.example.entregaFinal.Entidades.Venta;
import com.example.entregaFinal.Repository.ClienteRepository;
import com.example.entregaFinal.Repository.DetalleFacturaRepository;
import com.example.entregaFinal.Repository.ProductoRepository;
import com.example.entregaFinal.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    private Venta create;
    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    public List<Venta> findAll() {
        return this.ventaRepository.findAll();
    }

    public Optional<Venta> findById(int idVenta){
        return this.ventaRepository.findById(idVenta);
    }

    public  List<Venta> findByFecha(LocalDate fecha){ return  this.ventaRepository.findByFecha(fecha);}

    public List<Venta> findByIdCliente(Cliente clienteModel){return this.ventaRepository.findByIdCliente(clienteModel);}

    public List<Venta> findByTotal(int total){return  this.ventaRepository.findByTotal(total);}

    public Venta create (Venta nuevaVenta) throws ResourceNotFoundException {
        int idCliente = nuevaVenta.getIdCliente().getIdCliente();
        if(!clienteRepository.existsById(idCliente)){
            throw new ResourceNotFoundException("El cliente no existe");
        }

        Venta ventaModel;
        ventaModel = ventaRepository.save(nuevaVenta);
        if(ObjectUtils.isEmpty(ventaModel)){
            throw new ResourceNotFoundException("La venta no se pudo insertar");
        }

        return ventaModel;
    }

    public Venta update (Venta venta , int id){
        Optional<Venta> ventaBD = this.ventaRepository.findById(id);
        if(ventaBD.isPresent()){
            Venta v = ventaBD.get();
            v.setFecha(venta.getFecha());
            v.setIdCliente(venta.getIdCliente());
            v.setTotal(venta.getTotal());
            return this.ventaRepository.save(v);
        }else{
            return null;
        }
    }

}