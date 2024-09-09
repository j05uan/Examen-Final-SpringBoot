package detallesVenta.infraestructure.reporitory;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import detallesVenta.application.IDetallesVentaService;
import detallesVenta.domain.entity.DetallesVenta;

@Service
public class DetallesVentaAdapter implements IDetallesVentaService {

    @Autowired
    private IDetallesVentaRepositoty iDetallesVentaRepositoty;

    @Override
    public Optional<DetallesVenta> findByID(long id){
        return iDetallesVentaRepositoty.findById(id);
    }

    @Override
    public List<DetallesVenta> getAll(){
        return iDetallesVentaRepositoty.findAll();
    }

    @Override
    public DetallesVenta save(DetallesVenta bicicletas){
        return iDetallesVentaRepositoty.save(bicicletas);
    }

    @Override
    public void deleteById(long id){
        iDetallesVentaRepositoty.deleteById(id);
    }

}
