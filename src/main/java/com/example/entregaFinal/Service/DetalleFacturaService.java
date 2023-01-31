package com.example.entregaFinal.Service;

import com.example.entregaFinal.Entidades.DetalleFactura;
import com.example.entregaFinal.Entidades.Producto;
import com.example.entregaFinal.Entidades.Venta;
import com.example.entregaFinal.Repository.DetalleFacturaRepository;
import com.example.entregaFinal.Repository.ProductoRepository;
import com.example.entregaFinal.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleFacturaService {
    private DetalleFactura create;
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;
    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private ProductoRepository productoRepository;

    public List<DetalleFactura> findAll() {
        return this.detalleFacturaRepository.findAll();
    }

    public Optional<DetalleFactura> findById(int idDetalle_Venta){
        return this.detalleFacturaRepository.findById(idDetalle_Venta);
    }


    public List<DetalleFactura> findByCantidad(int cantidad){return  this.detalleFacturaRepository.findByCantidad(cantidad);}

    public DetalleFactura create (DetalleFactura nuevoDetalleFactura) throws ResourceNotFoundException {

        int cantidad =0;
        double precio = 0;
        Optional<Venta> ventaModelOptional = ventaRepository.findById(nuevoDetalleFactura.getIdVentaModel().getIdVenta());
        Venta ventaModel = new Venta();
        if(ventaModelOptional.isPresent()){
            ventaModel = ventaModelOptional.get();
            cantidad = nuevoDetalleFactura.getCantidad();
        }else{
            throw new ResourceNotFoundException("");
        }




        Optional<Producto> productoModelOptional = productoRepository.findById(nuevoDetalleFactura.getIdProductoModel().getIdProducto());
        Producto productoModel = new Producto();

        if(productoModelOptional.isPresent()){

            productoModel = productoModelOptional.get();

            precio = productoModel.getPrecio();
            int stockRestante = productoModel.getStock();
            int stockDeducir = nuevoDetalleFactura.getCantidad();

            if(stockRestante >= stockDeducir){
                productoModel.setStock(stockRestante - stockDeducir);
                productoRepository.save(productoModel);
                ventaModel.setTotal((int) (precio*cantidad));
            }else{
                ventaRepository.deleteById(nuevoDetalleFactura.getIdVentaModel().getIdVenta());
                throw new ResourceNotFoundException("");
            }
        }else{
            ventaRepository.deleteById(nuevoDetalleFactura.getIdVentaModel().getIdVenta());
            throw new ResourceNotFoundException("");
        }

        DetalleFactura detalleFacturaInsertada = detalleFacturaRepository.save(nuevoDetalleFactura);
        if(ObjectUtils.isEmpty(detalleFacturaInsertada)){
            ventaRepository.deleteById(nuevoDetalleFactura.getIdVentaModel().getIdVenta());
            throw new ResourceNotFoundException("");
        }

        return detalleFacturaInsertada;
    }

    public DetalleFactura update (DetalleFactura detalle_factura, int id){
        Optional<DetalleFactura> producto_ventaBD = this.detalleFacturaRepository.findById(id);
        if(producto_ventaBD.isPresent()){
            DetalleFactura pv = producto_ventaBD.get();
            pv.setCantidad(detalle_factura.getCantidad());
            pv.setIdProductoModel(detalle_factura.getIdProductoModel());
            pv.setIdVentaModel(detalle_factura.getIdVentaModel());
            return this.detalleFacturaRepository.save(pv);
        }else{
            return null;
        }
    }


}
