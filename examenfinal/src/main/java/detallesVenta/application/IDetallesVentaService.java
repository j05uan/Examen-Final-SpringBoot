package detallesVenta.application;


import java.util.List;
import java.util.Optional;

import detallesVenta.domain.entity.DetallesVenta;

public interface IDetallesVentaService {

    Optional<DetallesVenta> findByID(long id);
    List<DetallesVenta> getAll();
    DetallesVenta save(DetallesVenta detallesVenta);
    void deleteById(long id);

}
